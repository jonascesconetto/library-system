import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicInsertRevisorComponent } from './public-insert-revisor.component';

describe('PublicInsertRevisorComponent', () => {
  let component: PublicInsertRevisorComponent;
  let fixture: ComponentFixture<PublicInsertRevisorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicInsertRevisorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicInsertRevisorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
