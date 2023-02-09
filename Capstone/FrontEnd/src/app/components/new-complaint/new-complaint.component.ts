import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { statusRaised } from 'src/app/enviroments/environment';
import { Complaint } from 'src/app/models/complaint';
import { TypeOfProblem } from 'src/app/models/typeofproblem';
import { User } from 'src/app/models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompliantsService } from 'src/app/services/complaints.service';
import { TypesOfProblemService } from 'src/app/services/types-of-problem.service';

@Component({
  selector: 'app-new-complaint',
  templateUrl: './new-complaint.component.html',
  styleUrls: ['./new-complaint.component.css']
})
export class NewComplaintComponent implements OnInit{

  typesOfProblem:TypeOfProblem[]=[];
  selectedTypeOfProblem:TypeOfProblem|undefined;
  loading:boolean=false;

  error:string=""; 
  description:string="";



constructor(private typesOfProblemService:TypesOfProblemService,
  private complaintService:CompliantsService,
  private authenticationService:AuthenticationService,
  private router: Router){

}
  ngOnInit(): void {
    this.loading=true;
    this.typesOfProblemService.getTypesOfProblem().pipe(first()).subscribe(types => {
      this.typesOfProblem = types;
      this.loading=false;
      
    });
  }

  onClickRise(){
    this.loading=true;
    const currentComplaint:Complaint=new Complaint(new User(this.authenticationService.userValue?.id),this.description,this.selectedTypeOfProblem, statusRaised);
    this.complaintService.newComplaint(currentComplaint).pipe(first()).subscribe(
      {
      next: () => {
          this.loading=false;
          this.router.navigateByUrl('/complaints');
      },
      error: error => {
         this.error = error;
         this.loading = false;
      }
     
  });
  }

}
