import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrslrpaymentprizeDetailComponent } from './usrslrpaymentprize-detail.component';

describe('UsrslrpaymentprizeDetailComponent', () => {
  let component: UsrslrpaymentprizeDetailComponent;
  let fixture: ComponentFixture<UsrslrpaymentprizeDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsrslrpaymentprizeDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsrslrpaymentprizeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
