import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { Alert, AlertType } from './alert'

@Injectable({providedIn:'root'})
export class AlertService {

    alertSubject = new Subject<Alert>();

    success(message : string) {
        this.alertSubject.next(new Alert(message,AlertType.SUCCESS));
    }

    error(message : string) {
        this.alertSubject.next(new Alert(message,AlertType.DANGER));
    }

    getAlert() {
        return this.alertSubject.asObservable();
    }

}