import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRegistrationComponent } from './customer-registration/user-registration.component';
import { UserLoginComponent } from './customer-login/user-login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent } from './home/home.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAllTestComponent } from './view-all-test/view-all-test.component';
import { FindTestByIdComponent } from './find-test-by-id/find-test-by-id.component';
import { AddDiagnosticCenterComponent } from './add-diagnostic-center/add-diagnostic-center.component';
import { RemoveDiagnosticCenterComponent } from './remove-diagnostic-center/remove-diagnostic-center.component';
import { ApproveAppointmentsComponent } from './approve-appointments/approve-appointments.component';
import { SearchTestByIdComponent } from './search-test-by-id/search-test-by-id.component';

//declaring router path for corresponding components
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'aboutus', component: AboutUsComponent },
  { path: 'adminlogin', component: AdminLoginComponent },
  { path: 'customerlogin', component: UserLoginComponent },
  { path: 'customerregistration', component: UserRegistrationComponent },
  {path:  'customer/:customerName',component:CustomerProfileComponent},
  {path:  'admin/:adminName',component:AdminProfileComponent},
  {path:  'addtest',component:AddTestComponent},
  {path:  'removetest',component:ViewAllTestComponent},
  {path:  'admin/searchtestbyid',component:FindTestByIdComponent},
  {path:  'adddiagnosticcenter',component:AddDiagnosticCenterComponent},
  {path:  'removediagnosticcenter',component:RemoveDiagnosticCenterComponent},
  {path:  'approveappointments',component:ApproveAppointmentsComponent}, {path:  'viewAllTest',component: ViewAllTestComponent},
  {path:  'searchtestbyid',component:FindTestByIdComponent}];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

