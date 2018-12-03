import { Skill } from "../skill/skill";

export interface SkillCategory {
	idSkillCategory : number;
	name : string; 
	image : string; 
	dateCreated : Date;
	skills : Skill[];
}