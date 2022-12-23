import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Answer } from '../models/answer.model';

@Injectable({
  providedIn: 'root'
})
export class ResultsService {


  
  addAnswer(answer:Answer){
    return this.http.post(`http://localhost:3002/addAnswer`, answer)
  }

  getAnswers():Observable<Answer[]>{
    return this.http.get<Answer[]>(`http://localhost:3002/answers`).pipe(
      map(data => data.map(data => new Answer().deserialize(data)))
    );
  }
    

  getResulScore(answers:Answer[]):string{
    let correctNumber=0;
    answers.forEach(element => {
        if(element?.isCorrect) correctNumber++;
    });
    return correctNumber+"/"+answers.length;
  }

  constructor(private http: HttpClient) { }
}
