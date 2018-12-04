import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FeedbackService } from './feedback.service';
import { Feedback } from './feedback';
import { ProfileService } from '../profile/profile.service';
import { Profile } from '../profile/profile';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.css']
})
export class FeedbacksComponent implements OnInit {

  feedbackForm : FormGroup;
  @Input()
  profile : Profile;

  constructor(private formBuilder : FormBuilder, private feedbackService : FeedbackService, 
    private profileService : ProfileService) {
  }
  
  ngOnInit() {
    this.feedbackForm = this.formBuilder.group({
      author : ['', [Validators.required, Validators.maxLength(30)]],
      company : ['', [Validators.required, Validators.maxLength(30)]],
      text : ['', [Validators.required, Validators.maxLength(60)]]
    });
  }

  addFeedback() {
    if (this.feedbackForm.valid && !this.feedbackForm.pending && this.profile) {
      let feedback : Feedback = this.feedbackForm.getRawValue() as Feedback;
      feedback.profile = this.profile;
      feedback.dateCreated = new Date();
      this.feedbackService.addFeedback(feedback).subscribe();
    }
  }

}
