import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrdepartmentDetailsComponent } from './slrdepartment-details.component';

describe('SlrdepartmentDetailsComponent', () => {
  let component: SlrdepartmentDetailsComponent;
  let fixture: ComponentFixture<SlrdepartmentDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrdepartmentDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrdepartmentDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
