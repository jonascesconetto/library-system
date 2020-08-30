import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevisorColaLibrosComponent } from './revisor-cola-libros.component';

describe('RevisorColaLibrosComponent', () => {
  let component: RevisorColaLibrosComponent;
  let fixture: ComponentFixture<RevisorColaLibrosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevisorColaLibrosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevisorColaLibrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
