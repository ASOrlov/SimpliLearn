import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { withCache } from '@ngneat/cashew';
import { environment } from '../enviroments/environment';
import { TypeOfProblem } from '../models/typeofproblem';

@Injectable({
  providedIn: 'root'
})
export class TypesOfProblemService {

  constructor(private http: HttpClient) { }

  getTypesOfProblem() {
    return this.http.get<TypeOfProblem[]>(`${environment.apiUrl}/typesofproblem/all`,{
      context: withCache()
    });
  }
}
