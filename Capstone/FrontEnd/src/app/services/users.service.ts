import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


import { User } from '../models/user';
import { environment } from '../enviroments/environment';


@Injectable({ providedIn: 'root' })
export class UsersService {
    constructor(private http: HttpClient) { }

    getAllUsers() {
      return this.http.get<User[]>(`${environment.apiUrl}/users/all`);
    }

    modifyUser(user:User){
      
      return this.http.put<any>(`${environment.apiUrl}/users/update`, user);

    }

    newUser(user:User){
      
      return this.http.post<any>(`${environment.apiUrl}/users/new`, user);

    }

}