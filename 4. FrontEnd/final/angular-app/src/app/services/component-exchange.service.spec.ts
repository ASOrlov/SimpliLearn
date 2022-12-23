import { TestBed } from '@angular/core/testing';

import { ComponentExchangeService } from './component-exchange.service';

describe('ComponentExchangeService', () => {
  let service: ComponentExchangeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComponentExchangeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
