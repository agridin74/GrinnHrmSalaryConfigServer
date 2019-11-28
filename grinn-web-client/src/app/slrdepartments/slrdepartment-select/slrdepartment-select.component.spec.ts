import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrdepartmentSelectComponent } from './slrdepartment-select.component';

describe('SlrdepartmentSelectComponent', () => {
  let component: SlrdepartmentSelectComponent;
  let fixture: ComponentFixture<SlrdepartmentSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrdepartmentSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrdepartmentSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
