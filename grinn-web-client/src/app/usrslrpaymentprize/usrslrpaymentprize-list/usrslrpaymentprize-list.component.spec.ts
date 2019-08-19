import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrslrpaymentprizeListComponent } from './usrslrpaymentprize-list.component';

describe('UsrslrpaymentprizeListComponent', () => {
  let component: UsrslrpaymentprizeListComponent;
  let fixture: ComponentFixture<UsrslrpaymentprizeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsrslrpaymentprizeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsrslrpaymentprizeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
