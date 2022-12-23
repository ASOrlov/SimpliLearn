import { Component, OnInit } from '@angular/core';
import { Answer } from 'src/app/models/answer.model';
import { ResultsService } from 'src/app/services/results.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit{
  result:Answer[]=[];
  resultScore:string="";

  ngOnInit(): void {
    
    this.resultsService.getAnswers().subscribe((data)=>{
     this.result=data;
     this.resultScore=this.resultsService.getResulScore(data);
    });
    
  }


  constructor(private resultsService:ResultsService){

  }

}
