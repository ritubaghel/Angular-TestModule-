import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/customer.model';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  customer = new Customer();
  msg: String = '';
  constructor(private _service: CustomerService, private _router: Router) { }
  ngOnInit() {
  }
  loginCustomer() {
    this._service.loginCustomerFromRemote(this.customer).subscribe(
      data => {
        console.log(this.customer.customerName);
        this._router.navigate(['/customer',this.customer.customerName])//parameter routing
      },
      error => {
        this.msg = error.error.message;
      }
    )
  }
}