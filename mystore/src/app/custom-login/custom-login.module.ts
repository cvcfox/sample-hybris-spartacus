import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomNewCustomerLoginComponent } from './custom-new-customer-login/custom-new-customer-login.component';
import { ConfigModule, CmsConfig } from '@spartacus/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    CustomNewCustomerLoginComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    ConfigModule.withConfig({
    	cmsComponents:{
    		NewCustomerLoginComponent : {
    			component: CustomNewCustomerLoginComponent
    		}
    	},
    } as CmsConfig)
  ]
})
export class CustomLoginModule { }
