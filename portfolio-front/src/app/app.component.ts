import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'

declare var $ : any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'portfolio-front';

  private shortName : string;
  private mainActivity : string;
  
  constructor (private httpClient : HttpClient) {}

  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/webapi/profiles/1')
      .subscribe((profile : any) => {
        this.shortName = profile.shortName;
        this.mainActivity = profile.mainActivity;
      });
  }


  scrollClick(element) {
    $('#navbarContent').collapse('hide');

    $('html, body').animate({
      scrollTop: $( $(element).attr('href') ).offset().top
    }, 500);   
  }
}
