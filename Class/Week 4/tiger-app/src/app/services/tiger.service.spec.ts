import { TestBed } from '@angular/core/testing';

import { TigerService } from './tiger.service';

describe('CatService', () => {
  let service: TigerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TigerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
