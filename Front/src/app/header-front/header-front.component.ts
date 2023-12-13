import { Component,OnInit } from '@angular/core';
import {userservice} from '../Service/userservice'

@Component({
  selector: 'app-header-front',
  templateUrl: './header-front.component.html',
  styleUrls: ['./header-front.component.css']
})
export class HeaderFrontComponent implements OnInit{
  IsItIn!:boolean;
constructor(private userservice:userservice ){

}
  ngOnInit() : void{
    if(window.sessionStorage.getItem('token')){
      this.IsItIn=true;
    }
    else{
      this.IsItIn=false;
    }
  }

  logout(){
    this.userservice.logout();
  }
}
