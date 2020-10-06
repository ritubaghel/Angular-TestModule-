import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer.model';
import { Test } from '../models/test.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private _baseCustomerUrl='http://localhost:8082/customer';

  constructor(private _http: HttpClient) { }
  //providing the url to which browser will request
  private _customerLoginUrl = this._baseCustomerUrl+'/login';


  public loginCustomerFromRemote(customer: Customer): Observable<any> {
    //making HTTP POST request
    return this._http.post<any>(this._customerLoginUrl, customer)
  }


  private _customerRegUrl = this._baseCustomerUrl+'/customer';

  public addCustomer(customer: Customer): Observable<any> {
    //making HTTP POST request
    return this._http.post<any>(this._customerRegUrl, customer)
  }


}

