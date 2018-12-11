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
  
  constructor(private activatedRoute : ActivatedRoute) { }
  
  ngOnInit(): void {

  }

  scrollClick(element) {
    $('#navbarContent').collapse('hide');

    $('html, body').animate({
      scrollTop: $( '#' + $(element).attr('fragment') ).offset().top
    }, 500);    
  }

}