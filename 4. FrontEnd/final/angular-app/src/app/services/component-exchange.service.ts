import { Injectable } from '@angular/core';
import { Question } from '../models/question.model';

@Injectable({
  providedIn: 'root'
})
export class ComponentExchangeService {

  currentTest:Question[]=[];

  public setCurrentTest(test: Question[]) {
    this.currentTest=test;
    //console.log(JSON.stringify(test)); 
  }

  public getCurrentTest():Question[] {
    return this.currentTest; 
  }
}
