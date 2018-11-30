import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile/profile.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Profile } from '../profile/profile';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  profile$ : Observable<Profile>;

  constructor(private profileService : ProfileService) { }

  ngOnInit() {

    this.profile$ = this.profileService.getProfile(1);

  }

}
