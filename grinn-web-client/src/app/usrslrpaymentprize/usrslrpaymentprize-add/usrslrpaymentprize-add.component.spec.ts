import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrslrpaymentprizeAddComponent } from './usrslrpaymentprize-add.component';

describe('UsrslrpaymentprizeAddComponent', () => {
  let component: UsrslrpaymentprizeAddComponent;
  let fixture: ComponentFixture<UsrslrpaymentprizeAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsrslrpaymentprizeAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsrslrpaymentprizeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
