import { TestBed } from '@angular/core/testing';

import { RentServiceService } from './rent-service.service';

describe('RentServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RentServiceService = TestBed.get(RentServiceService);
    expect(service).toBeTruthy();
  });
});
