import { Component, OnInit, Input } from '@angular/core';
import { WorkDone } from './work-done';

@Component({
  selector: 'app-work-done',
  templateUrl: './work-done.component.html',
  styleUrls: ['./work-done.component.css']
})
export class WorkDoneComponent implements OnInit {

  @Input()
  workDone : WorkDone[];

  constructor() { }

  ngOnInit() {
  }

}
