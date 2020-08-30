import { TestBed, inject } from '@angular/core/testing';

import { RevisorService } from './revisor.service';

describe('RevisorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RevisorService]
    });
  });

  it('should be created', inject([RevisorService], (service: RevisorService) => {
    expect(service).toBeTruthy();
  }));
});
