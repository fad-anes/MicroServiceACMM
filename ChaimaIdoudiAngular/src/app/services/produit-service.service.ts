import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Produit } from '../model/Produit';


@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  constructor(private _http: HttpClient) { }

  apiUrl: string = environment.baseUrl

  getAllProducts() {
    return this._http.get<Produit[]>(this.apiUrl + "produit" + "/trouverProduits")
    //return this.http.get<Account[]>(this.apiUrl);
  }

  addProduct(Produit: Produit) {
    return this._http.post<Produit>(this.apiUrl + "produit" + "/ajoutProduit", Produit)
  }

  updateProduct(Produit: Produit) {
    return this._http.put<Produit>(this.apiUrl + "produit"+"MiseajourProduit", Produit)
  }

  deleteProduct(id_Produit: number) {
    return this._http.delete<Produit>(this.apiUrl + "produit"+"/supprimerProduit/" + id_Produit)
  }




}
