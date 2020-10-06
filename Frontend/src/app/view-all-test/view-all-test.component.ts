import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from '../models/test.model';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-view-all-test',
  templateUrl: './view-all-test.component.html',
  styleUrls: ['./view-all-test.component.css']
})
export class ViewAllTestComponent implements OnInit {
  allTest: Test[] = [];
  service: AdminService;
  msg:any;

  constructor(service: AdminService){
    this.service=service;
    this.getAllTest();
  }
 
  private getAllTest() {
    let observable: Observable<Test[]> = this.service.fetchAllTests();
    observable.subscribe(add => {
      this.allTest = add;
      console.log("inside success callback =" + this.allTest.length);
    }, err => console.log(err));
  } 

  confirmDelete(id:number){
    console.log(id);
    if(confirm('Are you sure to delete?')){
      this.service.deleteTest(id).subscribe(data=>{
        this.getAllTest(); 
       console.log(data);
      })
    }
  } 
  ngOnInit(): void {
  }
}
