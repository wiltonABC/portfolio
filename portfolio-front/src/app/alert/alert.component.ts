import { Component, OnInit, Input } from '@angular/core';
import { Alert, AlertType } from './alert';
import { AlertService } from './alert.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {

  private alerts : Alert[] = [];

  constructor(private alertService : AlertService) { }

  ngOnInit() {
    this.alertService.getAlert()
    .subscribe((alert : Alert) => {
      if (alert) {
        this.alerts.push(alert);
        setTimeout(() => this.removeAlert(alert), 3000);  
      }
    });
  }

  getAlertType(alert : Alert) : string {
    switch (alert.type) {
      case AlertType.SUCCESS:
        return 'alert-success';
      case AlertType.DANGER:
        return 'alert-danger';
    }
  }

  removeAlert(alertToRemove) {
    this.alerts = this.alerts.filter(alert => {
      alert != alertToRemove;
    });
  }
}
