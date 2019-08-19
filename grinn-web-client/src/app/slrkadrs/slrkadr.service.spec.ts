import { TestBed } from '@angular/core/testing';

import { SlrkadrService } from './slrkadr.service';

describe('SlrkadrService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SlrkadrService = TestBed.get(SlrkadrService);
    expect(service).toBeTruthy();
  });
});
