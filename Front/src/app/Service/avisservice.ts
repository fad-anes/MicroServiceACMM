import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { avis } from '../Models/avis';


@Injectable({
    providedIn: 'root',
  })
  export class avisservice {

    constructor(private router: Router,private http : HttpClient  ) {}


    ajouteravis(avis: avis): Observable<any> {
      const url ='/gateway/avis/create'; 
      let jwt =window.sessionStorage.getItem('token');
      jwt = "Bearer " + jwt;
      let httpHeaders = new HttpHeaders({"Authorization": jwt})
      return this.http.post<any>(url, avis, { headers: httpHeaders });
    }

listeavis(): Observable<avis[]>{
 
  const url ='/gateway/avis/all'; 

  return this.http.get<avis[]>(url);

    }

    deleteavis(id: number): Observable<any>{
      let jwt =window.sessionStorage.getItem('token');
      jwt = "Bearer " + jwt;
      let httpHeaders = new HttpHeaders({"Authorization": jwt})
      const url = `/gateway/avis/delete/${id}`;
          return this.http.delete<any>(url, { headers: httpHeaders });
    }
  }