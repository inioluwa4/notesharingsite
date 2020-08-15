import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { Login } from 'src/app/classes/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loggedUser: Login;
  public username: string;
  public password: string;
  public user: Login;

  constructor(
    public route: Router,
    private loginService: LoginService
    ) { }

  ngOnInit() {
    this.user = new Login();
    this.loginService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      },
      error => {
        this.loggedUser = null;
      }
    );
  }

  login() {
    this.loginService.login(this.username, this.password).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log('logged user ' + this.loggedUser);
        this.route.navigate(['/home']);

      }
    );

  }

  register() {
  
    console.log(this.user)

    this.loginService.register(this.user).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log('logged user ' + this.loggedUser);
        this.route.navigate(['/home']);

      }
    );

  }

  logout() {
    this.loginService.logout().subscribe(
      resp => {
        this.loggedUser = null;
        this.route.navigate(['/login']);

      }
    );
  }

}
