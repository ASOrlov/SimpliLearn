import { TestBed } from '@angular/core/testing';

import { TypesOfProblemService } from './types-of-problem.service';

describe('TypesOfProblemService', () => {
  let service: TypesOfProblemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypesOfProblemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
