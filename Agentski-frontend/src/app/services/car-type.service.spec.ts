import { TestBed } from '@angular/core/testing';

import { CarTypeService } from './car-type.service';

describe('CarTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CarTypeService = TestBed.get(CarTypeService);
    expect(service).toBeTruthy();
  });
});
