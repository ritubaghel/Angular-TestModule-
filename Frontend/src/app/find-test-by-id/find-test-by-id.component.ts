import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Center } from '../models/center.model';
import { Test } from '../models/test.model';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-find-test-by-id',
  templateUrl: './find-test-by-id.component.html',
  styleUrls: ['./find-test-by-id.component.css']
})
export class FindTestByIdComponent implements OnInit {
  msg='';
  foundTest:Test=null;
  service:AdminService;
  errMsg=null;
  constructor(service:AdminService) {
    this.service=service;
   }
   ngOnInit(): void {
  }
  
   findTestById(form:any):void{
    let details=form.value;
    let testId=details.testId;
    let centerId = details.centerId;

    let fetched:Observable<Test> =this.service.findTestById(testId);
   fetched.subscribe(
    test=>{
    this.foundTest=test; 
     },
     error => {    
      this.msg="Test with id "+ testId+" not exists!!";
    }   
    );   
   form.reset();
  
  }}
