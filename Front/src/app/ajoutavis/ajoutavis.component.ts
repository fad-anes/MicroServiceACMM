import { Component, TemplateRef, ViewChild ,OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {avisservice} from '../Service/avisservice';
import {avis} from '../Models/avis';

@Component({
  selector: 'app-ajoutavis',
  templateUrl: './ajoutavis.component.html',
  styleUrls: ['./ajoutavis.component.css']
})
export class AjoutavisComponent {
  avi= new avis();
  avis!: avis[];
  role!:any;
  isLoading:boolean=false;
  signinForm: FormGroup;
  message: string = '';
  @ViewChild('secondDialog', {static: true}) secondDialog!: TemplateRef<any>;
  constructor(private avisservice: avisservice,private dialogRef : MatDialog ,private formBuilder: FormBuilder) { 
    this.signinForm = this.formBuilder.group({
      message: ['', [Validators.required]]
    });
  }
  openDialogWithoutRef() {
    this.dialogRef.open(this.secondDialog);
  }
  onSubmit(templateRef: TemplateRef<any>) : void{
    const message = this.signinForm.get('message')?.value;
     
      if (!message) {
        this.message = "Oups ! Vous avez oublié de saisir le message!";

      this.dialogRef.open(templateRef);
      setTimeout(() => {
        this.dialogRef.closeAll();

      }, 4000); 
      return;
    }
    let idString = window.sessionStorage.getItem('id');
    let idNumber: number | null = idString ? parseInt(idString, 10) : null;
    this.avi.name = window.sessionStorage.getItem('name') ?? '';
    if (idNumber !== null) {
      this.avi.iduser = idNumber;
    } else {
      this.avi.iduser = 0; 
    }
    this.avi.message=message;
      this.avisservice.ajouteravis(this.avi).subscribe((data) => {
     
      if(data){
        this.isLoading = false;
        this.closePopup();
        location.reload();
      }
  
  
      },
        error => {
          if(error){
            this.message = error.message;
  
          this.dialogRef.open(templateRef);
          setTimeout(() => {
            this.dialogRef.closeAll();
  
          }, 4000); 
          return;}
         
          
        }
      );
   

  }




  
  closePopup(){
    this.dialogRef.closeAll();
  }
}
