import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorColaLibrosComponent } from './editor-cola-libros.component';

describe('EditorColaLibrosComponent', () => {
  let component: EditorColaLibrosComponent;
  let fixture: ComponentFixture<EditorColaLibrosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditorColaLibrosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorColaLibrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
