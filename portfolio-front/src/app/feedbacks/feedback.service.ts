import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Feedback } from "./feedback";

const API = environment.ApiUrl;

@Injectable({providedIn:'root'})
export class FeedbackService {

    constructor(private httpClient : HttpClient) {

    }

    public addFeedback(feedback : Feedback) {
        return this.httpClient.post(API + "/feedbacks", feedback, { headers:{'Content-Type':'application/json'} });
    }

}