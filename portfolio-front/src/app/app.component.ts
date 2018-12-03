import { Component, OnInit } from '@angular/core';
import { ProfileService } from './profile/profile.service';
import { Profile } from './profile/profile';
import { Skill } from './skill/skill';
import { WorkDone } from './work-done/work-done';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'portfolio-front';

  profile : Profile;
  skills : Skill[];
  workDone : WorkDone[];
  
  constructor (private profileService : ProfileService) {}

  ngOnInit(): void {
    this.profileService.getProfile(1).subscribe(profile => this.profile = profile );

    this.profileService.getSkills(1).subscribe(skills => this.skills = skills );

    this.profileService.getWorkDone(1).subscribe(workDone => this.workDone = workDone);
  }
}
