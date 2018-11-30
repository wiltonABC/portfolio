import { Component, OnInit } from '@angular/core';

declare var $ : any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'portfolio-front';
  
  constructor () {}

  ngOnInit(): void {
  }


  scrollClick(element) {
    $('#navbarContent').collapse('hide');

    $('html, body').animate({
      scrollTop: $( $(element).attr('href') ).offset().top
    }, 500);   
  }
}
