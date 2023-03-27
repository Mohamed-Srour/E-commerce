import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Customer } from 'src/app/models/customer';
import { OrderHasProduct } from 'src/app/models/orderhasproduct';
import { OrderHasProductId } from 'src/app/models/orderhasproductid';
import { Orders } from 'src/app/models/orders';
import { Product } from 'src/app/models/product';
import { ResponseViewModel } from 'src/app/models/responseviewmodel';
import { AuthService } from '../auth/auth.service';
import { ProductService } from '../product/product.service';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  orders = new Orders();
  public count = 0;
  public scoreSubject = new Subject<number>();


  constructor(private _http: HttpClient, private authService: AuthService) {

  }


  getCartValue() {
    if (this.authService.isCustomer()) {
      this.getcart(this.authService.getCustomerData().id).subscribe(
        response => {
          if (response.data != null) {
            this.orders = response.data;
            this.count = this.orders.orderHasProductsDTO.length;
          }
        });
    }
  }

  findNameProductById(id: number): String {
    let res: String = "";
    this.orders.orderHasProductsDTO.forEach(prod => {
      if (prod.product.id == id) {
        res = prod.product.name;
      }
    });
    return res;
  }


  getOrders(): Orders {
    return this.orders;
  }
  countProductCart(): number {
    this.scoreSubject.next(this.count);
    return this.count;
  }

  addProductToCart(product: Product) {
    if (this.authService.isLoggedIn()) { // check user logged in here
      if (this.orders.id == null) {  // if there is no cart or this first order
        this.addFirstProductToCart(product);
      } else {   // check this product not add to cart
        this.chexckBeforeAddToCart(product);
      }
    } else {

    }
  }

  chexckBeforeAddToCart(product: Product) {
    this.chickProductAddedToCart(product).subscribe(
      response => {
        // if this product not add to cart
        if (response.data == 0) {
          this.addProductToCustomerOrder(product, this.orders.id);
          this.addproductToOrderList(product);
          this.count++;
        }
      });
  }

  addFirstProductToCart(product: Product) {
    this.addOrder().subscribe(
      response => {
        this.orders = response.data;
        let id = response.data.id
        this.addProductToCustomerOrder(product, id);
        this.addproductToOrderList(product);
        this.count++;
      });
  }

  addproductToOrderList(product: Product) {
    let orderHasProduct = new OrderHasProduct();
    orderHasProduct.product = product;
    orderHasProduct.amount = 1;
    this.orders.orderHasProductsDTO.push(orderHasProduct);
    this.orders.totalPrice += product.price;
  }

  deleteProductFromOrders(product: Product) {
    let ind = 0;
    this.orders.orderHasProductsDTO.forEach(function (prod, index) {
      if (prod.product.id == product.id) {
        ind = index;
      }
    });
    this.orders.orderHasProductsDTO.splice(ind, 1);
    this.count--;
  }

  deleteProductFromCart(product: Product) {
    this.deleteProductCart(product).subscribe();
    this.deleteProductFromOrders(product);
  }

  deleteProductCart(product: Product): Observable<ResponseViewModel> {
    return this._http.delete<ResponseViewModel>('http://localhost:9090/ecommerce/productOrder/' + product.id + '/' + this.orders.id);
  }

  chickProductAddedToCart(product: Product): Observable<ResponseViewModel> {
    return this._http.get<ResponseViewModel>('http://localhost:9090/ecommerce/productOrder/' + product.id + '/' + this.orders.id);
  }

  addProductToCustomerOrder(product: Product, id: number) {
    // add first order in cart
    let orderHasProudect = new OrderHasProduct(new OrderHasProductId(id, product.id), 1);
    this._http.post<ResponseViewModel>('http://localhost:9090/ecommerce/productOrder', orderHasProudect).subscribe();
  }

  addOrder(): Observable<ResponseViewModel> {
    // take customer from toaken

    let order = new Orders(this.authService.getCustomerData(), 0, false, new Date());
    return this._http.post<ResponseViewModel>('http://localhost:9090/ecommerce/order', order);
  }

  getcart(id: number): Observable<ResponseViewModel> {
    return this._http.get<ResponseViewModel>('http://localhost:9090/ecommerce/cart/' + id);
  }

  updateWallit(): Observable<ResponseViewModel> {
    return this._http.get<ResponseViewModel>('http://localhost:9090/ecommerce/customer/walet/' + 
                                this.authService.getCurrentUserId() + '/' + this.orders.totalPrice);
  }



}
