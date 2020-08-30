import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicSearchTituloComponent } from './public-search-titulo.component';

describe('PublicSearchTituloComponent', () => {
  let component: PublicSearchTituloComponent;
  let fixture: ComponentFixture<PublicSearchTituloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicSearchTituloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicSearchTituloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
