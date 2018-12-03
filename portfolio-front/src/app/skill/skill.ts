import { SkillCategory } from "../skill-category/skill-category";

export interface Skill {
    idSkill : number; 
    skillCategory : SkillCategory; 
    name : string;
    dateCreated : Date;
}