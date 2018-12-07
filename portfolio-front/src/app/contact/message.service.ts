import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Message } from "./message"

const API = environment.ApiUrl;

@Injectable({providedIn:'root'})
export class MessageService {
    
    constructor(private httpClient : HttpClient) {

    }
    
    addMessage(message : Message) {
        return this.httpClient.post(API + '/messages', message);
    }
}