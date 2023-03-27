import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Product } from 'src/app/models/product';
import { AuthService } from 'src/app/services/auth/auth.service';
import { CartService } from 'src/app/services/cart/cart.service';
import { CategoryService } from 'src/app/services/category/category.service';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent {

  category=new Category();
  constructor(private route: ActivatedRoute, private categoryservice: CategoryService , private router:Router, private cartService: CartService,public authService:AuthService) {

    route.paramMap.subscribe((params: ParamMap) => {

      if (params.get('categoryid')) {

        this.categoryservice.getCategoryByID(+params.get('categoryid'))
          .subscribe(response => {
            
            this.category = response.data;
    
          })
      }
    })


  }
  viewProductDetails(product:Product):void{
  
    this.router.navigate(['/products', product.id], {
    })
  }

  addProductToCart(product: Product): void{
    this.cartService.addProductToCart(product);
  }

}
