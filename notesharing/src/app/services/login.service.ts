import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Login } from '../classes/login';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private appUrl = this.urlService.getUrl();
  //private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private headers = new HttpHeaders({
    'Content-Type': 'application/json' 
  });



  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  login(username: string, password: string): Observable<Login> {
    if (username && password) {
      // we are attempting to log in
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl+'login', body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const user: Login = resp as Login;
          if (user) {
            console.log(user);
          }
          return user;
        })
      );
    } else {
      // checking to see if we're logged in
      return this.http.get(this.appUrl+'login', {withCredentials: true}).pipe(
        map( resp => {
          const user: Login = resp as Login;
          if (user) {
          }
          console.log("Got User "+user)
          return user;
        })
      );
    }
  }

  
  register(user:Login): Observable<Login> {
    if (user) {
      // sending post

      const body = user;
      return this.http.post(this.appUrl+'register', body, {
        headers: this.headers,
        withCredentials: true
      }).pipe(
        map(resp => {
          const new_user: Login = resp as Login;
          if (new_user) {
            console.log(new_user);
          }
          return new_user;
        })
      );
    } 
  }
  logout(): Observable<object> {
    return this.http.delete(this.appUrl+'login', {withCredentials: true}).pipe(
      map(success => {
        return success;
      })
    );
  }

}



