import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Skill } from './skill';
import { SkillCategory } from '../skill-category/skill-category';
import { Observable, BehaviorSubject } from 'rxjs';
import { i18nExp } from '@angular/core/src/render3';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {

  private skillsSubject = new BehaviorSubject<Skill[]>([]);
  private skillsByCategory : SkillCategory[];
  
  @Input()
  set skills (value) {
    this.skillsSubject.next(value);
  } 

  get skills () {
    return this.skillsSubject.getValue();
  }

  
  constructor() { }
  
  ngOnInit(): void {
    this.skillsSubject.subscribe(skills => { 
  
      this.skillsByCategory = this.getSkillsByCategory(skills);
  
    });
  }

  private getSkillsByCategory(skills : Skill[]) : SkillCategory[] {

    //If skills is empty exit. Probably async data didn't arrive yet.
    if (!skills) return;

    let skillCategories = new Map<number, SkillCategory>();

    //Groups the skills by category and sets the associated list of skills for each category
    skills.forEach(skill => {

      if (!skillCategories.has(skill.skillCategory.idSkillCategory)) {
        let category = skill.skillCategory;
        category.skills = skills.filter(skillFilter => skillFilter.skillCategory.idSkillCategory == category.idSkillCategory );
        skillCategories.set(skill.skillCategory.idSkillCategory, category);
      }
    });

    let skillsByCategory : SkillCategory[] = [];

    //Converts the map to an array of SkillCategory
    skillCategories.forEach(category => skillsByCategory.push(category));

    return skillsByCategory;
  }

}
