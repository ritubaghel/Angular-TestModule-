import { AdminService } from './../service/admin.service';
import { Component, OnInit } from '@angular/core';
import { Test } from '../models/test.model';

@Component({
  selector: 'app-add-test',
  templateUrl: './add-test.component.html',
  styleUrls: ['./add-test.component.css']
})
export class AddTestComponent implements OnInit {
  msg='';
  service:AdminService;
  constructor(service:AdminService) {
    this.service=service;
   }

  addedTest:Test=null;
   result:Test=null;
  
  ngOnInit(): void {
  }

  register(form:any){
   let data= form.value;
   let testId;
   let testName= data.testName;
   let testPrice= data.testPrice;
   let centerId = data.centerId;

  this.addedTest = new Test();
  this.addedTest.testId=testId;
  this.addedTest.testName=testName;
  this.addedTest.testPrice=testPrice;
  this.addedTest.centerId=centerId;
 
  let result=this.service.addTest(this.addedTest); // adding to the store
    result.subscribe((test:Test)=>{
        this.result=test; 
    },   
    error => {    
      this.msg="Center Does not exists!!"; 
    }   
    );
    form.reset(); 
  }
}
