import { Component, OnInit } from '@angular/core';
import { CurrentProductService }  from '@spartacus/storefront';
import { Observable }  from 'rxjs';

@Component({
  selector: 'app-custom-product-images',
  templateUrl: './custom-product-images.component.html',
  styleUrls: ['./custom-product-images.component.scss']
})
export class CustomProductImagesComponent implements OnInit {

  product$: Observable<any> = this.currentProductService.getProduct();

  constructor(private currentProductService: CurrentProductService) { }

  ngOnInit(): void {
  }

}
