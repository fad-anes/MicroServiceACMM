import { Component, TemplateRef, ViewChild ,OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {userservice} from '../Service/userservice';
import {user} from '../Models/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{
  user!: user;
  users!: user[];
  role!:any;
  currentPage: number = 1;
  itemsPerPage: number = 4;
  hasaccess!:boolean;
  university!: string;
  token!:any;
  
  constructor(private userservice: userservice,private dialogRef : MatDialog ) { }

  ngOnInit(): void {
   this.userservice.listeUsers().subscribe((data) => {
    this.users=data;
    if (this.users && this.users.length > 0) {
      this.users = this.users.filter(user => ((user.role !== 'ADMIN')));
    }
   },
   error => {console.log(error) });
  }

  supprimer(id:number){
    this.userservice.deleteuser(id).subscribe((data) => {
     if(data){
      location.reload();
     }
     },
     error => {console.log(error) });
    }
  
}
