import { Component, TemplateRef, ViewChild ,OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {avisservice} from '../Service/avisservice';
import {avis} from '../Models/avis';
import { AjoutavisComponent } from '../ajoutavis/ajoutavis.component';

@Component({
  selector: 'app-avis',
  templateUrl: './avis.component.html',
  styleUrls: ['./avis.component.css']
})
export class AvisComponent implements OnInit{
  avi!: avis;
  avis!: avis[];
  isauthenth!:boolean;
  id!:any;
  constructor(private avisservice: avisservice,private dialogRef : MatDialog ) { }

  ngOnInit(): void {
    this.id=window.sessionStorage.getItem('id');
    if(window.sessionStorage.getItem('token')){
      this.isauthenth=true;
    }
    else{
      this.isauthenth=false;
    }
    this.avisservice.listeavis().subscribe((data) => {
      this.avis=data;
     },
     error => {console.log(error) });
  }

  supprimer(id:number){
    this.avisservice.deleteavis(id).subscribe((data) => {console.log(data)},(error) => {console.log(error)});

  }

  Ajout(){
    this.dialogRef.open(AjoutavisComponent);
  }
}
