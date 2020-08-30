import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorRechazarLibroComponent } from './editor-rechazar-libro.component';

describe('EditorRechazarLibroComponent', () => {
  let component: EditorRechazarLibroComponent;
  let fixture: ComponentFixture<EditorRechazarLibroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorRechazarLibroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorRechazarLibroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
