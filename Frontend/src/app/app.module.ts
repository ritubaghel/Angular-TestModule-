import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './customer-registration/user-registration.component';
import { UserLoginComponent } from './customer-login/user-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from "@angular/common/http";
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { MainpageComponent } from './mainpage/mainpage.component';

import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { CustomerService } from './service/customer.service';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAllTestComponent } from './view-all-test/view-all-test.component';
import { FindTestByIdComponent } from './find-test-by-id/find-test-by-id.component';
import { AddDiagnosticCenterComponent } from './add-diagnostic-center/add-diagnostic-center.component';
import { RemoveDiagnosticCenterComponent } from './remove-diagnostic-center/remove-diagnostic-center.component';
import { ApproveAppointmentsComponent } from './approve-appointments/approve-appointments.component';
import { SearchTestByIdComponent } from './search-test-by-id/search-test-by-id.component';


@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    UserLoginComponent,
    AdminLoginComponent,
    AboutUsComponent,
    HomeComponent,
    CustomerProfileComponent,
    MainpageComponent,
    AdminProfileComponent,
    AddTestComponent,
    ViewAllTestComponent,
    FindTestByIdComponent,
    AddDiagnosticCenterComponent,
    RemoveDiagnosticCenterComponent,
    ApproveAppointmentsComponent,
    SearchTestByIdComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,

  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
