
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../models/Admin.model';
import { Test } from '../models/test.model';


@Injectable({
  providedIn: 'root'
})
export class AdminService {

private _baseAdminUrl='http://localhost:8082/admin';

  constructor(private _http: HttpClient) { }
  //providing the url to which browser will request
  private _adminLoginUrl = this._baseAdminUrl+'/login';

  public loginAdminFromRemote(admin: Admin): Observable<any> {
    //making HTTP POST request
    return this._http.post<any>(this._adminLoginUrl, admin)
  }

  addTest(test:Test): Observable<Test>{
    let url=this._baseAdminUrl+"/centers/"+test.centerId+"/tests";
    let result:Observable<Test>= this._http.post<Test>(url,test);
    return result;
    }

    findTestById(id:number):Observable<Test>{
      let url='http://localhost:8082/customer/test/'+id;
      let observable:Observable<Test> =this._http.get<Test>(url);
      return observable;  
    }
   
    
    
    fetchAllTests(): Observable<Test[]> {
      let url = this._baseAdminUrl+"/tests";
      let observable: Observable<Test[]> = this._http.get<Test[]>(url);
      return observable;
    }
  
    deleteTest(id):Observable<any>
    {
      const url=this._baseAdminUrl+'/deletetest/'+id;
      return this._http.delete(url);
    }
}
