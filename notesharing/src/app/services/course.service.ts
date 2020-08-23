import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Course } from '../classes/course';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Login } from '../classes/login';


@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private appUrl = this.urlService.getUrl();
  //private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private headers = new HttpHeaders({
    'Content-Type': 'application/json' 
  });


  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  getCourses(): Observable<Array<Course>>{

      const url = this.appUrl+'courses/all';
    
    return this.http.get(url, {withCredentials: true}).pipe(
      map( resp => {
        const courses: Array<Course> = resp as Array<Course>;
        if (courses) {
        }
        console.log("Got Courses "+courses)
        return courses;
      })
    );
  }

  addCourses(payload: Array<Course>): Observable<Boolean> {
    if (payload) {
      // we are attempting to log in
      const body = JSON.stringify(payload)
      const url = this.appUrl+'courses/add';
      return this.http.post(url, body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const response: Boolean = resp as Boolean;
          if (response) {
            console.log("Courses added");
          }
          return response;
        })
      );
    } 
  }

  deleteCourse(): Observable<object> {
    const url = this.appUrl+'courses/remove';
    return this.http.delete(url, {withCredentials: true}).pipe(
      map(success => {
        return success;
      })
    );
  }

}