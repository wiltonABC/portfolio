import { Component, OnInit } from '@angular/core';
import { Profile } from './profile';
import { Skill } from '../skill/skill';
import { WorkDone } from '../work-done/work-done';
import { ProfileService } from './profile.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile : Profile;
  skills : Skill[];
  workDone : WorkDone[];
  
  constructor (private profileService : ProfileService, private activatedRoute : ActivatedRoute,
    private router : Router, private titleService : Title) {}

  ngOnInit(): void {
    const idProfile = this.activatedRoute.snapshot.params.idProfile;

    this.profileService.getProfile(idProfile).subscribe(profile => {
        this.profile = profile
        this.titleService.setTitle(this.titleService.getTitle() + ' - ' + this.profile.shortName + '\'s Profile' );
      },
      err => {
        if (err.status == 404) {
          this.router.navigateByUrl('not-found/Profile not found...');  
        } else {
          this.router.navigateByUrl('not-found/Error getting profile...');
        }
      });

    this.profileService.getSkills(idProfile).subscribe(skills => this.skills = skills );

    this.profileService.getWorkDone(idProfile).subscribe(workDone => this.workDone = workDone);
  }

}
