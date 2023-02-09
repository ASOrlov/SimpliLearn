import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string ='';
  password: string ='';
  showSpinner=false;
  
  loading:boolean=false;
  error:string='';



  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) 
    { 
       // redirect to home if already logged in
       if (this.authenticationService.userValue) 
       {
          this.router.navigate(['/']);
       }
    }



  ngOnInit() {
  }

  login() : void {
    this.loading = true;
    this.authenticationService.login(this.username, this.password)
        .pipe(first())
        .subscribe({
            next: () => {
                // get return url from query parameters or default to home page
                const returnUrl = this.route?.snapshot.queryParams['returnUrl'] || '/';
                this.router.navigateByUrl(returnUrl);
            },
            error: error => {
                this.error = error;
                this.loading = false;
            }
        });
}
}

