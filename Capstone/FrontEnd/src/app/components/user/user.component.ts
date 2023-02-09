import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { RolesService } from 'src/app/services/roles.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  
  isNew:boolean=false;

  user!:User;
  initialUser!:User;
  loading:boolean=false;

  error:string='';

  selectedRoleId:number|undefined;

  roles:Role[]=[];

  constructor(private componentExchangeService:ComponentExchangeService,
    private usersService:UsersService,
    private rolesService:RolesService,
    private router:Router
    ){

  }
  ngOnInit(): void {
    

    this.initialUser=this.componentExchangeService.getCurrentUser();
    this.selectedRoleId=this.initialUser.role?.id;
    
    this.isNew=this.initialUser.login===undefined;
    this.user=JSON.parse(JSON.stringify(this.initialUser))

    this.loading = true;
    this.rolesService.getRoles().pipe(first()).subscribe(roles =>
      {
        this.roles = roles;
        this.loading = false;
      });
    
  }

  onSaveChanges(){

    this.loading=true;
    this.user.role=this.roles?.find(role => role.id === this.selectedRoleId);

    if (this.isNew){
      this.usersService.newUser(this.user).pipe(first()).subscribe(
        {
        next: () => {
            this.loading=false;
            this.router.navigateByUrl('/users');
        },
        error: error => {
           this.error = error;
           this.loading = false;
        }
       
    });
    }

    else{
      this.usersService.modifyUser(this.user).pipe(first()).subscribe(
        {
        next: () => {
            this.loading=false;
            this.router.navigateByUrl('/users');
        },
        error: error => {
            this.error = error;
            this.loading = false;
        }
         
      });
    }
    

  }

}
