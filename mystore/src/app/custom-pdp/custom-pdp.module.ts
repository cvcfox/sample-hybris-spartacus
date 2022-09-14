import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomProductIntroComponent } from './custom-product-intro/custom-product-intro.component';
import { ConfigModule, CmsConfig } from '@spartacus/core';
import { CustomProductImagesComponent } from './custom-product-images/custom-product-images.component';

@NgModule({
  declarations: [
    CustomProductIntroComponent,
    CustomProductImagesComponent
  ],
  imports: [
    CommonModule,
    ConfigModule.withConfig({
    	cmsComponents:{
    		ProductImagesComponent : {
    			component: CustomProductImagesComponent
    		},
    		ProductSummaryComponent : {
    			component: CustomProductIntroComponent
    		}
    	},
    	backend: {
        	occ: {
            	endpoints: {
                	product: {
	                    list: 'products/${productCode}?fields=calories,extImg,code,name,summary,price(formattedValue),images(DEFAULT,galleryIndex),baseProduct',
                    },
                    paymentProviderSubInfo: 'users/${userId}/carts/${cartId}/payment/sop/request?responseUrl=orderPage_receiptResponseURL',
               	},
            },
        }
    } as CmsConfig)
  ]
})
export class CustomPdpModule { }
