import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorAceptarLibroComponent } from './editor-aceptar-libro.component';

describe('EditorAceptarLibroComponent', () => {
  let component: EditorAceptarLibroComponent;
  let fixture: ComponentFixture<EditorAceptarLibroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorAceptarLibroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorAceptarLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
