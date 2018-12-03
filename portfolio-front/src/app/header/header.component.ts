import { Component, OnInit, Input } from '@angular/core';

declare var $ : any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  @Input()
  shortName : string;

  @Input()
  mainActivity : string;

  constructor() { }

  scrollClick(element) {
    $('#navbarContent').collapse('hide');

    $('html, body').animate({
      scrollTop: $( $(element).attr('href') ).offset().top
    }, 500);   
  }

}