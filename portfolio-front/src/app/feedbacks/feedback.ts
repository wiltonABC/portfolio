import { Profile } from "../profile/profile";

export interface Feedback {
	idFeedback : number; 
	profile : Profile; 
	author : string; 
	company : string;
	text : string;
	dateCreated : Date;
}