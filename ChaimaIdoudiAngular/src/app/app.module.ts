import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterFrontComponent } from './footer-front/footer-front.component';
import { HeaderFrontComponent } from './header-front/header-front.component';
import { HeaderBackComponent } from './header-back/header-back.component';
import {FooterBackComponent} from './footer-back/footer-back.component'
import { MenubackComponent } from './menuback/menuback.component';
import { AdminComponent } from './admin/admin.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterFrontComponent,
    HeaderFrontComponent,
    HeaderBackComponent,
    FooterBackComponent,
    MenubackComponent,
    AdminComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
