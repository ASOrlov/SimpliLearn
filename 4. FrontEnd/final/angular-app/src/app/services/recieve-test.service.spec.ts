import { TestBed } from '@angular/core/testing';

import { RecieveTestService } from './recieve-test.service';

describe('RecieveTestService', () => {
  let service: RecieveTestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecieveTestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
