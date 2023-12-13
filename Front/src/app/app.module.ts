import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterFrontComponent } from './footer-front/footer-front.component';
import { HeaderFrontComponent } from './header-front/header-front.component';
import { HeaderBackComponent } from './header-back/header-back.component';
import {FooterBackComponent} from './footer-back/footer-back.component'
import { MenubackComponent } from './menuback/menuback.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { AvisComponent } from './avis/avis.component';
import { AjoutavisComponent } from './ajoutavis/ajoutavis.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterFrontComponent,
    HeaderFrontComponent,
    HeaderBackComponent,
    FooterBackComponent,
    MenubackComponent,
    AdminComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    AvisComponent,
    AjoutavisComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
