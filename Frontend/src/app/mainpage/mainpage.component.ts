import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../menu-service.service';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {
  loginlink: boolean = true;

  CustomerLogin: boolean = true;
  //for login menu
  constructor(private _menu: MenuServiceService) {
    this._menu.loginlink.subscribe(res => {
      this.loginlink = res
    })
  }
  ngOnInit(): void {
  }
}
