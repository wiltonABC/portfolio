import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormGroupDirective } from '@angular/forms';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';
import { ProfileService } from '../profile/profile.service';
import { Profile } from '../profile/profile';
import { BehaviorSubject, Subject } from 'rxjs';
import { AlertService } from '../alert/alert.service';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  feedbackForm : FormGroup;
  
  profileSubject = new Subject<Profile>();
  
  @Input()
  set profile (value) {
    this.profileSubject.next(value);
  };

  feedbackProfile : Profile;

  page : number = 1;

  feedbacksSubject = new BehaviorSubject<Feedback[]>(null);

  //Workaround to make full reset of the form marking it as not submitted to clear all validator until next submit
  @ViewChild(FormGroupDirective) formToReset;

  @ViewChild('btnSubmit') btnSubmit;

  constructor(private formBuilder : FormBuilder, private feedbackService : FeedbackService, 
    private profileService : ProfileService, private alertService : AlertService) {
  }
  
  ngOnInit() {
    this.feedbackForm = this.formBuilder.group({
      author : ['', [Validators.required, Validators.maxLength(30)]],
      company : ['', [Validators.required, Validators.maxLength(30)]],
      text : ['', [Validators.required, Validators.maxLength(60)]]
    });

    this.profileSubject.asObservable().subscribe(profile => {
      this.feedbackProfile = profile;
      this.updateFeedbacks()
    }
    
    );
  }

  addFeedback() {
    if (this.feedbackForm.valid && !this.feedbackForm.pending && this.feedbackProfile) {
      this.btnSubmit.nativeElement.disabled = true;
      let feedback : Feedback = this.feedbackForm.getRawValue() as Feedback;
      feedback.profile = this.feedbackProfile;
      feedback.dateCreated = new Date();
      this.feedbackService.addFeedback(feedback)
        .pipe(finalize(() => this.btnSubmit.nativeElement.disabled = false))
        .subscribe(() => {
          this.updateFeedbacks();
          this.alertService.success('Feedback successfully sent!');
          if (this.formToReset) {
            this.formToReset.resetForm();
          }
        }, () => this.alertService.error('Error sending the feedback!'));
    }
  }

  updateFeedbacks() {
      this.page = 1;
      this.feedbackService.getFeedbacks(this.feedbackProfile.idProfile,this.page,3).subscribe(feedbacks => this.feedbacksSubject.next(feedbacks));
  }

  getFeedbacks() {
    return this.feedbacksSubject.asObservable();
  }

  showOlder() {
    this.page++;
    this.feedbackService.getFeedbacks(this.feedbackProfile.idProfile,this.page,3).subscribe(feedbacks => this.feedbacksSubject.next(feedbacks));
  }

}
