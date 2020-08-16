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
  public formview0 : Boolean
  public formview1 : Boolean 
 

  constructor(
    public route: Router,
    private loginService: LoginService
    ) { }

  ngOnInit() {
    this.formview0 = false;
    this.formview1 = false;

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

  
  form0() {
    this.formview0 = true
    this.formview1 = false

  }
  form1(){
    this.formview0 = false
    this.formview1 = true
  }
  form2(){
    this.formview0 = false
    this.formview1 = true
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
