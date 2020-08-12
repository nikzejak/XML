import { TestBed } from '@angular/core/testing';

import { TransmissionTypeService } from './transmission-type.service';

describe('TransmissionTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TransmissionTypeService = TestBed.get(TransmissionTypeService);
    expect(service).toBeTruthy();
  });
});
