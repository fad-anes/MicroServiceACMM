import { Component, TemplateRef, ViewChild ,OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {userservice} from '../Service/userservice';
import {user} from '../Models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  message: string = '';
  email!: string;
  password!: string;
  name!: string;
  user = new user();
  signinForm: FormGroup;
  names: any[] = [];
  @ViewChild('secondDialog', {static: true}) secondDialog!: TemplateRef<any>;
  constructor(private userservice: userservice, private router: Router,
              private dialog: MatDialog, public dialogRef: MatDialog,private formBuilder: FormBuilder
  ) { this.signinForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
    name: ['', Validators.required]
  });}

  openDialogWithoutRef() {
    this.dialog.open(this.secondDialog);
  }

  onSubmit(templateRef: TemplateRef<any>) : void{
    const email = this.signinForm.get('email')?.value;
      const password = this.signinForm.get('password')?.value;
      const name = this.signinForm.get('name')?.value;
      console.log(email,password,name)
      if (!email || !password || !name) {
        this.message = 'Oups ! Vous avez oublié de saisir votre e-mail et/ou votre mot de passe et/ou votre nom!';

      this.dialog.open(templateRef);
      setTimeout(() => {
        this.dialog.closeAll();

      }, 4000); 
      return;
    } if (!email.includes('@') || !email.includes('.')) {
      this.message = " L'adresse e-mail n'est pas valide.";
      this.dialog.open(templateRef);
      setTimeout(() => {
        this.dialog.closeAll();
      }, 3000); 
      return;
    }
    if (password.length < 8) {
      this.message = '8 caractères requis pour le mot de passe.';
      this.dialog.open(templateRef);
      setTimeout(() => {
        this.dialog.closeAll();
      }, 3000); 
      return;
    }
    this.user.email=email;
    this.user.password=password;
    this.user.name=name
      this.userservice.ajouterUser(this.user).subscribe((data) => {
     
        
        
        this.message = "Bienvenue à SGLASS. Vous pouvez maintenant acceder a votre compte.";
  
        this.dialog.open(templateRef);
        setTimeout(() => {
          this.dialog.closeAll();
        }, 6000);
        return;
  
  
      },
        error => {
          this.message = "Bienvenue à SGLASS. Vous pouvez maintenant acceder a votre compte.";
  
        this.dialog.open(templateRef);
        setTimeout(() => {
          this.dialog.closeAll();
        }, 6000);
        return;
          
        }
      );
   

  }
}
