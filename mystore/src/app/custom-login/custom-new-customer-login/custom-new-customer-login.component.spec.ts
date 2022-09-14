import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomNewCustomerLoginComponent } from './custom-new-customer-login.component';

describe('CustomNewCustomerLoginComponent', () => {
  let component: CustomNewCustomerLoginComponent;
  let fixture: ComponentFixture<CustomNewCustomerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomNewCustomerLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomNewCustomerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
