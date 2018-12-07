import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormGroupDirective } from '@angular/forms';
import { MessageService } from './message.service';
import { Message } from './message';
import { Profile } from '../profile/profile';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contactForm : FormGroup;

  @Input()
  profile : Profile;

  //Workaround to make full reset of the form marking it as not submitted to clear all validator until next submit
  @ViewChild(FormGroupDirective) formToReset;

  constructor(private formBuilder : FormBuilder, private messageService : MessageService) { }

  ngOnInit() {
    this.contactForm = this.formBuilder.group({
      name : ['', [Validators.required, Validators.maxLength(40)]],
      email : ['', [Validators.required, Validators.maxLength(60), Validators.email]],
      subject : ['', [Validators.required, Validators.maxLength(50)]],
      message : ['', [Validators.required, Validators.maxLength(300)]]
    });
  }

  sendMessage() {
    if (this.contactForm.valid && !this.contactForm.pending && this.profile) {
      
      let message = this.contactForm.getRawValue() as Message;
      message.dateCreated = new Date();
      message.profile = this.profile;
      this.messageService.addMessage(message).subscribe(() => {
        if (this.formToReset) {
          this.formToReset.resetForm();
        }
      });
    }
  }

}
