import { TestBed } from '@angular/core/testing';

import { SlrdepartmentService } from './slrdepartment.service';

describe('SlrdepartmentService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SlrdepartmentService = TestBed.get(SlrdepartmentService);
    expect(service).toBeTruthy();
  });
});
