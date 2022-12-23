import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Question } from '../models/question.model';

@Injectable({
  providedIn: 'root'
})

export class RecieveTestService {
  
  private questions:Question[]=[];

public getQuestions(): Observable<Question[]> {
  
  
  return this.http.get<Question[]>(`http://localhost:3002/test`).pipe(
    map(data => data.map(data => new Question().deserialize(data)))
  );
}

  constructor(private http: HttpClient) { }
}
