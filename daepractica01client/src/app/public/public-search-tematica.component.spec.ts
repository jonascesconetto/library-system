import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicSearchTematicaComponent } from './public-search-tematica.component';

describe('PublicSearchTematicaComponent', () => {
  let component: PublicSearchTematicaComponent;
  let fixture: ComponentFixture<PublicSearchTematicaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicSearchTematicaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicSearchTematicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
