import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrslrpaymentprizeEditComponent } from './usrslrpaymentprize-edit.component';

describe('UsrslrpaymentprizeEditComponent', () => {
  let component: UsrslrpaymentprizeEditComponent;
  let fixture: ComponentFixture<UsrslrpaymentprizeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsrslrpaymentprizeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsrslrpaymentprizeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
