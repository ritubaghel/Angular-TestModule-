import { Component, OnInit } from '@angular/core';
import { Customer } from '../models/customer.model';
import { Router } from '@angular/router';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  msg = '';
  customer: Customer = new Customer();

  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit(): void {
  }
  addCustomer(): any {
    this.customerService.addCustomer(this.customer)
      .subscribe(data => { //subscribing the service
        //using router to navigating to a particular URL
        this.router.navigate(['/customerlogin'])
        console.log(data)
      },
        error => {
          this.msg = error.error.message;
        }
      );
  };
}

