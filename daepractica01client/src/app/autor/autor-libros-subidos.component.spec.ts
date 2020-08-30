import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorLibrosSubidosComponent } from './autor-libros-subidos.component';

describe('AutorLibrosSubidosComponent', () => {
  let component: AutorLibrosSubidosComponent;
  let fixture: ComponentFixture<AutorLibrosSubidosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorLibrosSubidosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorLibrosSubidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
