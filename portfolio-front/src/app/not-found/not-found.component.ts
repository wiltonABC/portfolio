import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit {

  message : string;

  constructor(private activatedRoute : ActivatedRoute) { }

  ngOnInit() {

    this.activatedRoute.snapshot.params.err ?
      this.message = this.activatedRoute.snapshot.params.err : this.message = 'Page not found...'

  }

}
