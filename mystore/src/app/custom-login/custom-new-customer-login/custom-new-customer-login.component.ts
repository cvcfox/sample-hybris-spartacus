import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-custom-new-customer-login',
  templateUrl: './custom-new-customer-login.component.html',
  styleUrls: ['./custom-new-customer-login.component.scss']
})
export class CustomNewCustomerLoginComponent implements OnInit {

 checkoutForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    password: new FormControl(''),
    uid: new FormControl('')
  });

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  
  onSubmit(): void {
    console.warn('Your registration has been submitted', this.checkoutForm.value);

    this.http.post<any>('https://localhost:9002/toptalcommercewebservices/v2/electronics-spa/users', this.checkoutForm.value).subscribe((data:any) => {
        alert("Success, please login.");
    })
   this.checkoutForm.reset();
  }
  

}
