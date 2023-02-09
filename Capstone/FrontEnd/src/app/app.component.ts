import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './models/user';
import { AuthenticationService } from './services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';

  user?: User | null;

    constructor(private authenticationService: AuthenticationService,
      private router:Router) {
        this.authenticationService.user.subscribe(x => this.user = x);
    }

    get isAdmin() {
      return this.user?.role?.toString()==="ADMINISTRATOR";
    }

    logout() {
        this.authenticationService.logout();
    }

    goComlaints() {
      this.router.navigateByUrl('/complaints');
    }

    goUsers() {
      this.router.navigateByUrl('/users');
    }
}

