import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { user } from '../Models/user';


@Injectable({
    providedIn: 'root',
  })
  export class userservice {

    constructor(private router: Router,private http : HttpClient  ) {}

    loginKeyLock(data: any): Observable<any> {
        const headers = new HttpHeaders({
          'Content-Type': 'application/x-www-form-urlencoded'
        });
        return this.http.post("/keylock/", data.toString(), { headers });
      }

    loginuser(user:user) {
      const url = 'http://localhost:8091/user/login'; 
      return this.http.post<any>(url,user);
    }

    ajouterUser(user: user): Observable<any> {
      const url ='http://localhost:8091/user/create'; 
      return this.http.post<any>(url, user);
    }
logout() {
  window.sessionStorage.removeItem('token');
  window.sessionStorage.removeItem('name');
  window.sessionStorage.removeItem('password');
  window.sessionStorage.removeItem('email');
  window.sessionStorage.removeItem('role');
  window.sessionStorage.removeItem('id');
  this.router.navigate(['/Home']);
}

listeUsers(): Observable<user[]>{
  let jwt = window.sessionStorage.getItem('token');
  const url ='/gateway/user/all'; 
  let httpHeaders = new HttpHeaders()
  .set('Authorization', 'Bearer ' + jwt);
  return this.http.get<user[]>(url,{headers:httpHeaders});

    }

    edituser(user: user): Observable<any>{
      const url = `/gateway/user/update/${user.id}`;
      let jwt = window.sessionStorage.getItem('token');
      jwt = "Bearer " + jwt;
      let httpHeaders = new HttpHeaders({"Authorization": jwt})
      return this.http.put(url,user,{ headers:httpHeaders });
    }

    deleteuser(id: number): Observable<any>{
      let jwt =window.sessionStorage.getItem('token');
      jwt = "Bearer " + jwt;
      let httpHeaders = new HttpHeaders({"Authorization": jwt})
      const url = `/gateway/user/delete/${id}`;
          return this.http.delete<any>(url, { headers: httpHeaders });
    }

    oneuser(id: any):Observable<user> {
      const url = `/gateway/user/one/${id}`;
      let jwt = window.sessionStorage.getItem('token');
      console.log(jwt)
      jwt = "Bearer "+jwt;
      let httpHeaders = new HttpHeaders({"Authorization":jwt})
      return this.http.get<user>(url,{headers:httpHeaders});
      }
  }