import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrdepartmentListComponent } from './slrdepartment-list.component';

describe('SlrdepartmentListComponent', () => {
  let component: SlrdepartmentListComponent;
  let fixture: ComponentFixture<SlrdepartmentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrdepartmentListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrdepartmentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
