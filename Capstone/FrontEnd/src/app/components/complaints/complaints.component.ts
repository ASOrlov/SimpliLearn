import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Complaint } from 'src/app/models/complaint';
import { CompliantsService } from 'src/app/services/complaints.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { first } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { customerRole, engineerRole, managerRole } from 'src/app/enviroments/environment';

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.css']
})


export class ComplaintsComponent implements OnInit, AfterViewInit{

  @ViewChild(MatPaginator) paginator!: MatPaginator ;
  
  complaints:Complaint[]=[];
  currentStatus: string="All";
  displayedColumns: string[] = ['customer', 'pinCode', 'description', 'typeOfProblem', 'status', 'engineer','manager'];
  dataSource=new MatTableDataSource<Complaint>(); 
  loading:boolean=false;


  filterComplaintsByStatus(status:string){
    this.dataSource.data=this.complaints.filter(str=>str.status?.name===status);
  }



  raiseComplaint(){
    this.router.navigateByUrl('new-complaint');
  }

  onStatusButtonClick(){
     switch(this.currentStatus) {
       
      case "All":{
        this.dataSource.data=this.complaints;
        break
      }
      case "Raised":{
        this.filterComplaintsByStatus("Raised");
        break
      }
      case "Assigned":{
        this.filterComplaintsByStatus("Assigned");
        break;
      }
      case "WIP":{
        this.filterComplaintsByStatus("WIP");
        break;
      }
      case "Resolved":{
        this.filterComplaintsByStatus("Resolved");
        break;
      }
      case "Escalated":{
        this.filterComplaintsByStatus("Escalated");
        break;
      }
      default:{
        break;
      }

    }
   }

  onRowClick(complaint: Complaint) {
    this.componentExchangeService.setCurrentComplaint(complaint);
    this.router.navigateByUrl('complaint');
  }

  constructor(private complaintsService:CompliantsService
    ,private router: Router
    ,private componentExchangeService:ComponentExchangeService
    ,private authenticationService:AuthenticationService){
  }
  
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }
   
  ngOnInit(): void {
    


    const role=String(this.authenticationService.userValue?.role);
    const needFilterByEngineerId=(role==engineerRole);
    const needFilterByCustomerId=(role==customerRole);
    
    this.loading = true;
        this.complaintsService.getAllCompliants().pipe(first()).subscribe(complaints => {
            
            if (needFilterByEngineerId){
              this.complaints=complaints.filter(complaint=>complaint.engineer?.id==this.authenticationService.userValue?.id)       
            }
            else if (needFilterByCustomerId){
              this.complaints=complaints.filter(complaint=>complaint.customer?.id==this.authenticationService.userValue?.id) 
            }
            else{
              this.complaints = complaints;
            }

            this.loading = false;
            this.dataSource.data=this.complaints;
        });

   
    
     //this.complaints=this.dataSource.data.slice();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
