import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Produit } from 'src/app/model/Produit';
import { ProduitServiceService } from 'src/app/services/produit-service.service';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private fb: FormBuilder, private productService: ProduitServiceService) { }
  addProductForm!: FormGroup;
  ListDesProduits!: Produit[];
  ngOnInit(): void {
    this.addProductForm = this.fb.group({

      nom: ['', Validators.required],
      marque: ['', Validators.required],
      image: ['', Validators.required],
      description: ['', Validators.required],
      quantite: ['', Validators.required],
      prix: ['', Validators.required],
      categorie: ['', Validators.required],
    });

    this.getProducts()
  }
  getProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.ListDesProduits = data;
    })
  }

  aajoutProduit() {
    console.log("ccccc")
    if (this.addProductForm.invalid) {
      console.log("ffffff")
      // If the form is invalid, mark all fields as touched to display validation errors
      this.addProductForm.markAllAsTouched();
      return;
    }
    const productData: Produit = {
      id: 0,
      nom: this.addProductForm.get('nom')?.value,
      marque: this.addProductForm.get('marque')?.value,
      image: this.addProductForm.get('image')?.value,
      description: this.addProductForm.get('description')?.value,
      quantite: parseInt(this.addProductForm.get('quantite')?.value),
      prix: this.addProductForm.get('prix')?.value,
      categorie: this.addProductForm.get('categorie')?.value,



      //nomEt: this.userProfileForm.get('nom')?.value,
      //prenomEt: this.userProfileForm.get('prenom')?.value,
    }
    console.log(productData)
    this.productService.addProduct(productData).subscribe(
      (response) => {
        console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaa")
        console.log('Update successful:', response);
        // Handle success, if needed
        this.closeModel2()
      },
      (error) => {
        console.error('Error during update:', error);
        // Handle error, if needed
      }
    );
  }
  openModel2() {
    const modelDiv = document.getElementById('newModal');
    if (modelDiv != null) {
      modelDiv.style.display = 'block';
    }
  }
  closeModel2() {
    const modelDiv = document.getElementById('newModal');
    if (modelDiv != null) {
      modelDiv.style.display = 'none';
    }
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(
      () => {
        console.log('Product deleted successfully');
        // Update the product list after deletion
        this.getProducts();
      },
      (error) => {
        console.error('Error deleting product:', error);
        // Handle error if needed
      }
    );
  }
}
