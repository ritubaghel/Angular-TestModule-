import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../menu-service.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {
  customername: String = '';
 //injecting into constructor
  constructor(private _header: MenuServiceService,
    private route: ActivatedRoute) {
  }
  ngOnInit() {
    this._header.loginlink.next(false)
    //fetching out customerName from the url to display on page
    let customerName = this.route.snapshot.paramMap.get('customerName');
    this.customername = customerName;
  }
}
