import { Component, TemplateRef, ViewChild  } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {userservice} from '../Service/userservice';
import { user } from '../Models/user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  signinForm: FormGroup;
  data!:any;
  message: string = '';
  user= new user();

  @ViewChild('secondDialog', {static: true}) secondDialog!: TemplateRef<any>;
  constructor(private userservice: userservice, private router: Router,
              private dialog: MatDialog, public dialogRef: MatDialog,private formBuilder: FormBuilder
  ) { this.signinForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });}

  onSubmit(templateRef: TemplateRef<any>) : void{
    const email = this.signinForm.get('email')?.value;
      const password = this.signinForm.get('password')?.value;
    this.user.email=email;
    this.user.password=password;
    this.userservice.loginuser( this.user).subscribe((data) => { 
          if(data){
             sessionStorage.setItem('email', data.email);
            sessionStorage.setItem('password', data.password);
             sessionStorage.setItem('role', data.role);
             sessionStorage.setItem('id', data.id);
             sessionStorage.setItem('name', data.name);
            if( sessionStorage.getItem('role')=="ADMIN"){
            this.data=this.encodeFormData({ grant_type: "password", client_id: "gateway",client_secret:"fPWIUd2gBgCBEsaS2hpaW8N6BaWQp1FS" ,username: "anes",password:"anes" });
            this.userservice.loginKeyLock( this.data).subscribe((data) => { 
              sessionStorage.setItem('token', data.access_token);
                  console.log(window.sessionStorage.getItem('token'))
                  this.router.navigate(['/Admin']);
                  },
                    error => { console.log(error)}
                  );
          }
          else if( sessionStorage.getItem('role')=="CLIENT"){
            this.data=this.encodeFormData({ grant_type: "password", client_id: "gateway",client_secret:"fPWIUd2gBgCBEsaS2hpaW8N6BaWQp1FS" ,username: "tohami",password:"tohami" });
            this.userservice.loginKeyLock( this.data).subscribe((data) => { 
              sessionStorage.setItem('token', data.access_token);
                  console.log(window.sessionStorage.getItem('token'))
                  this.router.navigate(['/Home']);
                  },
                    error => { console.log(error)}
                  );
          }}
          },
            error => { 
              if(error.status==404){
                this.message = "Il n'y a pas de compte avec cet email";
              this.dialog.open(templateRef);
              setTimeout(() => {
                this.dialog.closeAll();
              }, 4000); 
              return;}
              else if(error.status==400){
                this.message = 'Mot de passe incorrect';
                this.dialog.open(templateRef);
                setTimeout(() => {
                  this.dialog.closeAll();
                }, 4000); 
                return;}
            }
          );
     
  }

  private encodeFormData(data: any): string {
    const params = new URLSearchParams();

    for (const key in data) {
      if (data.hasOwnProperty(key)) {
        params.set(key, data[key]);
      }
    }

    return params.toString();
  }
}
