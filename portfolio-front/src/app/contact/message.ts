import { Profile } from "../profile/profile";

export interface Message {
    idMessage : number;
	profile : Profile;
	name : string;
	email : string; 
	subject : string;
	message : string;
	dateCreated : Date;
}