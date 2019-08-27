import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlrdepartmentItemComponent } from './slrdepartment-item.component';

describe('SlrdepartmentItemComponent', () => {
  let component: SlrdepartmentItemComponent;
  let fixture: ComponentFixture<SlrdepartmentItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlrdepartmentItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlrdepartmentItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
