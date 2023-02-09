import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { withCache } from '@ngneat/cashew';
import { environment } from '../enviroments/environment';
import { Status } from '../models/status';

@Injectable({
  providedIn: 'root'
})
export class StatusesService {

  constructor(private http: HttpClient) { }

  getStatuses() {
    return this.http.get<Status[]>(`${environment.apiUrl}/statuses/all`,{
      context: withCache()
    });
  }
}
