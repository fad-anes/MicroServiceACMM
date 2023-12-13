import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/Produit';
import { ProduitServiceService } from '../services/produit-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  ListDesProduits!: Produit[];
  constructor(private produitService: ProduitServiceService) { }

  ngOnInit(): void {
    this.produitService.getAllProducts().subscribe(data =>{
      this.ListDesProduits = data;
    })
  }

}
