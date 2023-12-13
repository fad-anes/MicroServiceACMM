import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { AvisComponent } from './avis/avis.component';
import { AjoutavisComponent } from './ajoutavis/ajoutavis.component';
const routes: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full' },
  { path: 'Home', component: HomeComponent , title:"Acceuil" },
  { path: 'Admin', component: AdminComponent , title:"Admin" },
  { path: 'login', component: LoginComponent , title:"Se Connecter" },
  { path: 'register', component: RegisterComponent , title:"S'inscrire" },
  { path: 'profile', component: ProfileComponent , title:"Votre Profile" },
  { path: 'avis', component: AvisComponent , title:"Les Avis" },
  { path: 'AjoutAvis', component: AjoutavisComponent , title:"Ajout Avis" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
