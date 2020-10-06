import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';
import { Admin } from '../models/Admin.model';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  admin = new Admin();
  msg: String = '';
  constructor(private _service: AdminService, private _router: Router) { }

  ngOnInit() {
  }
  
  loginAdmin() {
    this._service.loginAdminFromRemote(this.admin).subscribe(
      data => {
        console.log(this.admin.adminName);
        this._router.navigate(['/admin',this.admin.adminName])//parameter routing
      },
      error => {
        this.msg = error.error.message;
      }
    )
  }
}
