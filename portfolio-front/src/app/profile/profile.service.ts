import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Profile } from "./profile";
import { Observable, BehaviorSubject } from "rxjs";
import { Injectable, OnInit } from "@angular/core";

const API = environment.ApiUrl;

@Injectable({ providedIn:'root' })
export class ProfileService {

    private profileSubject = new BehaviorSubject<Profile>(null);
    
    constructor(private httpClient : HttpClient) { 
        this.httpClient.get<Profile>(API + '/profiles/' + '1')
            .subscribe(profile => this.profileSubject.next(profile));
    }

    public getProfile() : Observable<Profile> {

        return this.profileSubject.asObservable();
        
    }
}