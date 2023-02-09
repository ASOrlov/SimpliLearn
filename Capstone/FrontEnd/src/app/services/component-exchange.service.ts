import { Injectable } from '@angular/core';
import { Complaint } from '../models/complaint';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ComponentExchangeService {

  currentComplaint!: Complaint;
  currentUser!: User;

  setCurrentComplaint(currentComplaint:Complaint){
    this.currentComplaint=currentComplaint;
   
  }

  getCurrentComplaint():Complaint{
    return this.currentComplaint;
  }



  setCurrentUser(user:User){
    this.currentUser=user;
  }

  getCurrentUser():User{
    return this.currentUser;
  }

  constructor() { }
}
