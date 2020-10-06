import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindTestByIdComponent } from './find-test-by-id.component';

describe('FindTestByIdComponent', () => {
  let component: FindTestByIdComponent;
  let fixture: ComponentFixture<FindTestByIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindTestByIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindTestByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
