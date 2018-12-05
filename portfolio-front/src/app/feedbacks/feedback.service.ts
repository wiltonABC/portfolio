import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
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

    public getFeedbacks(id : number, page : number, pageCount : number) {
        const params = new HttpParams().append('page', page.toString())
            .append('pageCount', pageCount.toString());
        return this.httpClient.get<Feedback[]>(API + "/profiles/" + id 
            + "/feedbacks", { params });
    }

}