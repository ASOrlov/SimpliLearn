import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Answer } from 'src/app/models/answer.model';
import { Question } from 'src/app/models/question.model';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { RecieveTestService } from 'src/app/services/recieve-test.service';
import { ResultsService } from 'src/app/services/results.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit{

  counter:number=0;
  numberOfQuestion:number=0;
  
  questions:Question[]=[];
  selectedAnswerOption:Answer|any;
  currentQuestion:Question | any;
  
  
  
  
  constructor(private recieveTestService:RecieveTestService
    ,private router: Router
    ,private resultsService:ResultsService
    ,private componentExchangeService:ComponentExchangeService
    ){
  
  }
  
  ngOnInit(): void {
    this.questions=this.componentExchangeService.getCurrentTest();
    this.currentQuestion=this.questions[0];
    this.numberOfQuestion=this.questions.length;
  }
    
  onSubmit():void{
  
    this.resultsService.addAnswer(new Answer(
      this.currentQuestion.textOfQuestion,
      this.selectedAnswerOption.textOfAnswer,
      this.selectedAnswerOption.isCorrect)).subscribe(
        data => {
          console.log('message::::', data);
          if(this.counter<this.numberOfQuestion-1){
            this.counter++;
            this.currentQuestion=this.questions[this.counter];
            this.selectedAnswerOption=null;
          }else
          {
            this.router.navigateByUrl('result');
          }
        }
      );

  }
  
 }
  
