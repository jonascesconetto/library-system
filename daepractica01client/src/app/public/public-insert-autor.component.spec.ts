import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicInsertAutorComponent } from './public-insert-autor.component';

describe('PublicInsertAutorComponent', () => {
  let component: PublicInsertAutorComponent;
  let fixture: ComponentFixture<PublicInsertAutorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicInsertAutorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicInsertAutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
