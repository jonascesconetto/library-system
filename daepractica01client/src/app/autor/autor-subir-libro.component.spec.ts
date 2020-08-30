import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorSubirLibroComponent } from './autor-subir-libro.component';

describe('AutorSubirLibroComponent', () => {
  let component: AutorSubirLibroComponent;
  let fixture: ComponentFixture<AutorSubirLibroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutorSubirLibroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorSubirLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
