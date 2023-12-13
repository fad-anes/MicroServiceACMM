import { Component } from '@angular/core';
import {userservice} from '../Service/userservice'
@Component({
  selector: 'app-header-back',
  templateUrl: './header-back.component.html',
  styleUrls: ['./header-back.component.css']
})
export class HeaderBackComponent {
  constructor(private userservice:userservice ){

  }
  logout(){
    this.userservice.logout();
  }
}
