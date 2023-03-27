import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { AuthService } from 'src/app/services/auth/auth.service';
import { CategoryService } from 'src/app/services/category/category.service';
import { ProductService } from 'src/app/services/product/product.service';


@Component({
  selector: 'app-manage-products',
  templateUrl: './manage-products.component.html',
  styleUrls: ['./manage-products.component.css']
})
export class ManageProductsComponent implements OnInit {

  constructor(private http: HttpClient, private formbuilder: FormBuilder, private productservice: ProductService, private categoryservice: CategoryService , private authservice:AuthService) { }

  productform: FormGroup;
  categoryform: FormGroup;
  ngOnInit(): void {

    this.productform = this.formbuilder.group({

      productname: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(40)]],
      productdesc: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(250)]],
      productprice: [1, [Validators.required, Validators.min(1)]],
      productrate: [1, [Validators.required, Validators.max(5), Validators.min(1)]],
      productstock: [1, [Validators.required, Validators.min(1), Validators.max(100000), Validators.pattern("^[0-9]*$")]],
      productcategory: ['', [Validators.required]],
      productimage: ['', [Validators.required]]
    });
    this.categoryservice.getAllCategories().subscribe(
      response => {
        this.categories = response.data;
      })

    this.categoryform = this.formbuilder.group({
      categoryname: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(99)]],
      categorydesc: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(200)]]

    })

  }

  event: any;
  categories: Category[];
  category = new Category();
  setEvent(event: any): void {
    this.event = event;

  }

  addProduct() {
    var product = new Product();
    product.name = this.productform.value.productname;
    product.description = this.productform.value.productdesc;
    product.price = this.productform.value.productprice;
    product.rate = this.productform.value.productrate;
    product.stock = this.productform.value.productstock;
    let i = 0;
    while (i < this.categories.length) {
      if (this.categories[i].name == this.productform.value.productcategory) {

        product.categories.push(this.categories[i]);
      }
      i++
    }
    product.imagePath = "assets//images//" + this.event.target.files[0].name;
    this.productservice.add(product);
       this.authservice.openDialog("Product added successfully");
          


  }

  addImage(): void {
    if (this.event.target.files.length > 0) {
      const file = this.event.target.files[0];
      const formdata = new FormData();
      formdata.append('file', file);

      this.productservice.uploadImage(formdata);
    }
  }

  isCategoryNameExists(categoryname: string , descname:string) {

    let i = 0;
    let  isvalid = true;
    while (i < this.categories.length) {
      if (categoryname == this.categories[i].name){
            isvalid = false ;
      }
      i++;
    }
    if (isvalid ==false){
      this.authservice.openDialog("Error:Category name already exists");
    }
    else{
      let category = new Category();
      category.name= categoryname;
      category.description=descname;
      this.authservice.openDialog("Category added successfully")
      this.categoryservice.addCategory(category);
    }
  }




}
