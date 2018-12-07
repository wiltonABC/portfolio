import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormGroupDirective } from '@angular/forms';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';
import { ProfileService } from '../profile/profile.service';
import { Profile } from '../profile/profile';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  feedbackForm : FormGroup;
  @Input()
  profile : Profile;

  page : number = 1;

  feedbacksSubject = new BehaviorSubject<Feedback[]>(null);

  //Workaround to make full reset of the form marking it as not submitted to clear all validator until next submit
  @ViewChild(FormGroupDirective) formToReset;

  constructor(private formBuilder : FormBuilder, private feedbackService : FeedbackService, 
    private profileService : ProfileService) {
  }
  
  ngOnInit() {
    this.feedbackForm = this.formBuilder.group({
      author : ['', [Validators.required, Validators.maxLength(30)]],
      company : ['', [Validators.required, Validators.maxLength(30)]],
      text : ['', [Validators.required, Validators.maxLength(60)]]
    });

    this.updateFeedbacks();
  }

  addFeedback() {
    if (this.feedbackForm.valid && !this.feedbackForm.pending && this.profile) {
      let feedback : Feedback = this.feedbackForm.getRawValue() as Feedback;
      feedback.profile = this.profile;
      feedback.dateCreated = new Date();
      this.feedbackService.addFeedback(feedback).subscribe(() => {
        this.updateFeedbacks();
        if (this.formToReset) {
          this.formToReset.resetForm();
        }
      });
    }
  }

  updateFeedbacks() {
    this.page = 1;
    this.feedbackService.getFeedbacks(1,this.page,3).subscribe(feedbacks => this.feedbacksSubject.next(feedbacks));
  }

  getFeedbacks() {
    return this.feedbacksSubject.asObservable();
  }

  showOlder() {
    this.page++;
    this.feedbackService.getFeedbacks(1,this.page,3).subscribe(feedbacks => this.feedbacksSubject.next(feedbacks));
  }

}