import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemoveDiagnosticCenterComponent } from './remove-diagnostic-center.component';

describe('RemoveDiagnosticCenterComponent', () => {
  let component: RemoveDiagnosticCenterComponent;
  let fixture: ComponentFixture<RemoveDiagnosticCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemoveDiagnosticCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemoveDiagnosticCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
