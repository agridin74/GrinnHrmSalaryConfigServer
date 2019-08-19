import { TestBed } from '@angular/core/testing';

import { UsrslrpaymentprizeService } from './usrslrpaymentprize.service';

describe('UsrslrpaymentprizeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsrslrpaymentprizeService = TestBed.get(UsrslrpaymentprizeService);
    expect(service).toBeTruthy();
  });
});
