import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Profile } from "./profile";
import { Observable, BehaviorSubject } from "rxjs";
import { Injectable } from "@angular/core";
import { Skill } from "../skill/skill";
import { WorkDone } from "../work-done/work-done";

const API = environment.ApiUrl;

@Injectable({ providedIn:'root' })
export class ProfileService {

    profileSubject
    
    constructor(private httpClient : HttpClient) { 
    }

    public getProfile(id : number) : Observable<Profile> {

        return this.httpClient.get<Profile>(API + '/profiles/' + id);
    }

    public getSkills(id : number) : Observable<Skill[]> {
        return this.httpClient.get<Skill[]>(API + '/profiles/' + id + '/skills');
    }

    public getWorkDone(id : number) : Observable<WorkDone[]> {
        return this.httpClient.get<WorkDone[]>(API + '/profiles/' + id + '/work-done');
    }
}