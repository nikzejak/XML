import { TestBed } from '@angular/core/testing';

import { CarBrandService } from './car-brand.service';

describe('CarBrandService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarBrandService = TestBed.get(CarBrandService);
    expect(service).toBeTruthy();
  });
});
