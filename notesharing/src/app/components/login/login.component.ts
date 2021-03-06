import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { Login } from 'src/app/classes/login';
import { Course } from 'src/app/classes/course';
import { CourseService } from 'src/app/services/course.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loggedUser: Login;
  public class: Course;
  private courses: Array<Course>

  public username: string;
  public password: string;
  public message: string = "";
  public user: Login;
  public formview0 : Boolean
  public formview1 : Boolean 
  public formview2 : Boolean 
  public username_verify : Boolean

 

  constructor(
    public route: Router,
    private loginService: LoginService,
    private courseService: CourseService
    ) { }

  ngOnInit() {
    this.courses = []
    
    this.formview0 = false;
    this.formview1 = false;

    this.user = new Login();
    this.class = new Course();

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
        this.route.navigate(['/notesharing']);

      }
    );
    console.log(this.username, this.password)


  }

  
  form0() {
    this.message = ""
    this.formview0 = true
    this.formview1 = false
    this.formview2 = false


  }
  form1(){
    if (this.validate(this.user.password, "password")){
      this.message = ""
      this.formview0 = false
      this.formview1 = true
      this.formview2 = false

    }


  }
  form2(){
    this.message = ""
    this.formview0 = false
    this.formview1 = false
    this.formview2 = true

  }

  register() {
  
    console.log(this.user)
    console.log(this.courses)

    this.loginService.register(this.user).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log('logged user ' + this.loggedUser);
        // this.route.navigate(['/login']);

        this.courseService.addCourses(this.courses).subscribe(
          resp => {
            console.log('Courses - ' + resp);
            this.route.navigate(['/home']);
    
          }
        );
    

      }
      
    );

  }

  validate(data:string, data_type:string){

    if (data_type == "username"){
      if (data.length < 6){
        this.message = `Username must be at least 6 characters             
        `
        return false
      }

      return true
    }
    
    if (data_type == "password"){
      if (data.length < 8 || !this.hasUpperCase || !this.hasNumber){
        this.message = `Password must be at least 8 characters.
                        Password must contain at least one upper case.
                        Passwword must contain at least one number.`
        return false
      }
      return true
    }





  }



  addClass() {
    console.log(this.class)
    this.courses.push(this.class)
    // this.user.courses = this.classes
    console.log(this.courses)
    this.class = new Course()





  }

  logout() {
    this.loginService.logout().subscribe(
      resp => {
        this.loggedUser = null;
        this.route.navigate(['/login']);

      }
    );
  }



  hasUpperCase(str: string) {
    return (/[A-Z]/.test(str));
  }
  hasNumber(str: string) {
    return (/[0-9]/.test(str));

  }
}
