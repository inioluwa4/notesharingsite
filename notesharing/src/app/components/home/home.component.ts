import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { CourseService } from 'src/app/services/course.service';
import { Router } from '@angular/router';
import { Login } from 'src/app/classes/login';
import { Course } from 'src/app/classes/course';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public courseList: Array<Course>;
  public notes_query: string;


  constructor(
    public route: Router,
    private loginService: LoginService,
    private courseService: CourseService
    ) { }

  ngOnInit(): void {
    this.courseList = []
    this.notes_query = ""

    console.log()

    this.courseService.getCourses().subscribe(
      resp => {
        console.log('Courses - ' + resp);
        this.courseList = resp
        

      }
    );
  }
    
  search(){
    console.log("Searching Notes - "+this.notes_query)
  }


}
