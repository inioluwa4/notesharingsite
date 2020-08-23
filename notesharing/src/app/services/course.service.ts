import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Course } from '../classes/course';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


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
  // logout(): Observable<object> {
  //   return this.http.delete(this.appUrl+'login', {withCredentials: true}).pipe(
  //     map(success => {
  //       return success;
  //     })
  //   );
  // }

}