import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchTestByIdComponent } from './search-test-by-id.component';

describe('SearchTestByIdComponent', () => {
  let component: SearchTestByIdComponent;
  let fixture: ComponentFixture<SearchTestByIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchTestByIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchTestByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
