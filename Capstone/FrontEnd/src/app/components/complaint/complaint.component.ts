import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { administratorRole, customerRole, engineerAccesseableStatusesId, engineerRole, managerRole, statusAssigned } from 'src/app/enviroments/environment';
import { Complaint } from 'src/app/models/complaint';
import { Status } from 'src/app/models/status';
import { TypeOfProblem } from 'src/app/models/typeofproblem';
import { User } from 'src/app/models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CompliantsService } from 'src/app/services/complaints.service';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { StatusesService } from 'src/app/services/statuses.service';
import { TypesOfProblemService } from 'src/app/services/types-of-problem.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent implements OnInit{
  
  isAdministrator=false;
  isCustomer=false;
  isManager=false;
  isEngineer=false;
  error:string="";
  

  loading:boolean=false;
  
  
  complaint!:Complaint;
  initialComplaint!:Complaint;

  users:User[]=[];
  engineerList:User[]=[];
  managerList:User[]=[];
  customerList:User[]=[];

  statuses:Status[]=[];
  typesOfProblem:TypeOfProblem[]=[];


  selectedEngineerId:number|undefined;
  selectedManagerId:number|undefined;
  selectedCustomerId:number|undefined;

  selectedStatusId:number|undefined;
  selectedTypeOfProblemId:number|undefined;





  ngOnInit(): void {
   
    this.initialComplaint=this.componentExchangeService.getCurrentComplaint();
    //this.complaint=Object.create(this.initialComplient);
    this.complaint=JSON.parse(JSON.stringify(this.initialComplaint));


    const role=String(this.authenticationService.userValue?.role);
    this.isAdministrator=(role==administratorRole);
    this.isCustomer=(role==customerRole);
    this.isManager=(role==managerRole);
    this.isEngineer=(role==engineerRole);

   
    let counter=1;

    this.loading = true;
   
    this.usersService.getAllUsers().pipe(first()).subscribe(users => {
        this.users = users;
        
        this.engineerList=JSON.parse(JSON.stringify(this.users));
        this.managerList=JSON.parse(JSON.stringify(this.users));
        this.customerList=JSON.parse(JSON.stringify(this.users));

        //&&engineer.pinCode==this.initialComplaint.customer?.pinCode
        
        this.engineerList=this.engineerList.filter(engineer=>
          engineer.role?.name===engineerRole||engineer.id===this.initialComplaint.engineer?.id
         
        )
        
        this.managerList=this.users.filter(manager=>
          (manager.role?.name==managerRole)||manager.id==this.initialComplaint.manager?.id
        )

        if (this.isManager){
          this.engineerList=this.users.filter(engineer=>
            (engineer.pinCode==this.initialComplaint.customer?.pinCode && engineer.role?.name===engineerRole)||engineer.id==this.initialComplaint.engineer?.id
        )
        }

        this.selectedEngineerId=this.initialComplaint.engineer?.id;
        this.selectedManagerId=this.initialComplaint.manager?.id;
        this.selectedCustomerId=this.initialComplaint.customer?.id;


        //for manager need filtering engineerList
        counter++;
        if (counter===3) this.loading=false;
   });

    this.statusesService.getStatuses().pipe(first()).subscribe(statuses => {
      
      this.statuses = statuses

      //engineer filter
      if (this.isEngineer){
        this.statuses = statuses.filter(status=>
          engineerAccesseableStatusesId.includes(status.id)
          || status.id==this.initialComplaint.status?.id);
      }
      else{
        this.statuses = statuses
      }
            
      this.selectedStatusId=this.initialComplaint.status?.id;
      counter++;
      if (counter===3) this.loading=false;

    });

    this.typesOfProblemService.getTypesOfProblem().pipe(first()).subscribe(types => {
      this.typesOfProblem = types;
      this.selectedTypeOfProblemId=this.initialComplaint.typeOfProblem?.id;
      counter++;
      if (counter===3) this.loading=false;
    });

    
    

  }


  onSaveChanges(){
    
    //Change status Assigned if this is manager
    if (this.isManager) {
      this.selectedStatusId=statusAssigned.id;
      this.selectedManagerId=this.authenticationService.userValue?.id
    }
    
    this.complaint.customer=this.customerList?.find(customer => customer.id === this.selectedCustomerId);
    this.complaint.manager=this.managerList?.find(manager => manager.id === this.selectedManagerId);
    this.complaint.engineer=this.engineerList?.find(engineer => engineer.id === this.selectedEngineerId);

    this.complaint.status=this.statuses?.find(status => status.id === this.selectedStatusId);
    this.complaint.typeOfProblem=this.typesOfProblem?.find(typeOfProblem => typeOfProblem.id === this.selectedTypeOfProblemId);
    
    this.loading=true;

    this.complaintsService.modifyComplaint(this.complaint).pipe(first()).subscribe(
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


  
    
 

  constructor(
    private componentExchangeService:ComponentExchangeService,
    private statusesService:StatusesService,
    private typesOfProblemService:TypesOfProblemService,
    private usersService:UsersService,
    private complaintsService:CompliantsService,
    private authenticationService:AuthenticationService,
    private router:Router
    ){
    
  }

}