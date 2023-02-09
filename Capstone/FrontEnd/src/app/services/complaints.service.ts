import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../enviroments/environment';
import { Complaint } from '../models/complaint';



@Injectable({
  providedIn: 'root'
})
export class CompliantsService {

  constructor(private http: HttpClient) {
    
   }

  getAllCompliants() {
    return this.http.get<Complaint[]>(`${environment.apiUrl}/complaints/all`);
  }
  
  modifyComplaint(complaint:Complaint){
    return this.http.put<any>(`${environment.apiUrl}/complaints/update`, complaint);
  }

  newComplaint(complaint:Complaint){
      
    return this.http.post<any>(`${environment.apiUrl}/complaints/new`, complaint);

  }
}
