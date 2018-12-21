import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

declare var $ : any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  
  @Input()
  shortName : string;
  
  @Input()
  mainActivity : string;

  url : string;

  idProfile : number;
  
  constructor(private activatedRoute : ActivatedRoute) { }
  
  ngOnInit(): void {
    this.idProfile = this.activatedRoute.snapshot.params.idProfile;
  }

  scrollClick(element) {
    $('#navbarContent').collapse('hide');

    $('html, body').animate({
      scrollTop: $( '#' + $(element).attr('fragment') ).offset().top
    }, 500);    
  }

}