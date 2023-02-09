import { TestBed } from '@angular/core/testing';

import { CompliantsService } from './complaints.service';

describe('CompliantsService', () => {
  let service: CompliantsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompliantsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
