import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicLibrosPublicadosComponent } from './public-libros-publicados.component';

describe('PublicLibrosPublicadosComponent', () => {
  let component: PublicLibrosPublicadosComponent;
  let fixture: ComponentFixture<PublicLibrosPublicadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicLibrosPublicadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicLibrosPublicadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
