import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../menu-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  adminname: String = '';
 //injecting into constructor
  constructor(private _header: MenuServiceService,
    private route: ActivatedRoute) {
  }
  ngOnInit() {
    this._header.loginlink.next(false)
    //fetching out adminName from the url to display on page
    let adminName = this.route.snapshot.paramMap.get('adminName');
    this.adminname = adminName;
  }
}

