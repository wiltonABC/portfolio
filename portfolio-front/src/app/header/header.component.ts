import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile/profile.service';
import { Profile } from '../profile/profile';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private profile : Profile;

  constructor(private profileService : ProfileService) { }

  ngOnInit() {
    this.profileService.getProfile().subscribe(profile => this.profile = profile);
  }

}