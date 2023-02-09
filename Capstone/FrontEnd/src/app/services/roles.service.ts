import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { withCache } from '@ngneat/cashew';
import { environment } from '../enviroments/environment';
import { Role } from '../models/role';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(private http: HttpClient) { }

    getRoles() {
      return this.http.get<Role[]>(`${environment.apiUrl}/roles/all`,{
        context: withCache()
      });
    }
}
