import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrdepartmentEditComponent } from './slrdepartment-edit.component';

describe('SlrdepartmentEditComponent', () => {
  let component: SlrdepartmentEditComponent;
  let fixture: ComponentFixture<SlrdepartmentEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrdepartmentEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrdepartmentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
