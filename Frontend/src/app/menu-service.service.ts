import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {
  constructor() { }
 // for making main menu Admin,customer login visible or invisible
  loginlink = new BehaviorSubject(false)
}
