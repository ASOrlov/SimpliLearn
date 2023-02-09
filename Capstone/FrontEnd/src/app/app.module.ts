import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ComplaintsComponent } from './components/complaints/complaints.component';
import { CompliantsService } from './services/complaints.service';
import { UsersComponent } from './components/users/users.component';
import { UserComponent } from './components/user/user.component';

import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {ComplaintComponent } from './components/complaint/complaint.component';
import {MatSelectModule } from '@angular/material/select';
import {NewComplaintComponent } from './components/new-complaint/new-complaint.component';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCardModule} from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';

import { JwtInterceptor } from './helpers/jwt.interceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { ErrorInterceptor } from './helpers/error.interceptor';
import { LoginComponent } from './components/login/login.component';

import { HttpCacheInterceptorModule } from '@ngneat/cashew';






@NgModule({
  declarations: [
    AppComponent,
    ComplaintsComponent,
    ComplaintComponent,
    NewComplaintComponent,
    UsersComponent,
    UserComponent,
    LoginComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonToggleModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatTabsModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    HttpClientModule,
    HttpCacheInterceptorModule.forRoot()

  ],
  providers: [
    CompliantsService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
