import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { User } from 'src/app/models/user';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  @ViewChild(MatPaginator) paginator!: MatPaginator ;
  loading:boolean=false;
  
  users:User[]=[];

  displayedColumns: string[] = ['name', 'login', 'role', 'pinCode', 'address', 'phoneNumber'];
  dataSource=new MatTableDataSource<User>(); 


  newUser(){
    this.componentExchangeService.setCurrentUser(new User());
    this.router.navigateByUrl('user');
  }

  
  onRowClick(user: User) {
    this.componentExchangeService.setCurrentUser(user);
    this.router.navigateByUrl('user');
  }

  constructor(private usersService:UsersService
    ,private router: Router
    ,private componentExchangeService:ComponentExchangeService){
  }
  
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }
   
  ngOnInit(): void {
    
    this.loading = true;
        this.usersService.getAllUsers().pipe(first()).subscribe(users => {

          this.loading = false;
            this.users = users;
            this.dataSource.data=this.users;
        });
   
 
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
