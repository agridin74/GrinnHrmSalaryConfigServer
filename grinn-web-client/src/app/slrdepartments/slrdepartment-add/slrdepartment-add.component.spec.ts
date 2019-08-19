import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSlrdepartmentComponent } from './slrdepartment-add.component';

describe('CreateSlrdepartmentComponent', () => {
  let component: CreateSlrdepartmentComponent;
  let fixture: ComponentFixture<CreateSlrdepartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSlrdepartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSlrdepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
