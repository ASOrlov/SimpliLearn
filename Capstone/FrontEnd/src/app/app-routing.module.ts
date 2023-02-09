import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComplaintComponent } from './components/complaint/complaint.component';
import { ComplaintsComponent } from './components/complaints/complaints.component';
import { LoginComponent } from './components/login/login.component';
import { NewComplaintComponent } from './components/new-complaint/new-complaint.component';
import { UserComponent } from './components/user/user.component';
import { UsersComponent } from './components/users/users.component';
import { AuthGuard } from './helpers/auth.guard';

const routes: Routes = [
  
  {
    path: '', 
    redirectTo: '/complaints',
    pathMatch: 'full'
  },
  {
    path:'complaints',
    component:ComplaintsComponent,
        canActivate: [AuthGuard]
  },
  {
    path:'complaint',
    component:ComplaintComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'new-complaint',
    component:NewComplaintComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'users',
    component:UsersComponent,
    canActivate: [AuthGuard]
    ,    data: { roles: ["ADMINISTRATOR"] }
  },
  {
    path:'user',
    component:UserComponent,
    canActivate: [AuthGuard],
     data: { roles: ["ADMINISTRATOR"] }
  },
  {
    path:'login',
    component: LoginComponent },
        // otherwise redirect to home
  { 
    path: '**', redirectTo: '' 
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
