import { TestBed } from '@angular/core/testing';

import { FuelTypeService } from './fuel-type.service';

describe('FuelTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FuelTypeService = TestBed.get(FuelTypeService);
    expect(service).toBeTruthy();
  });
});
