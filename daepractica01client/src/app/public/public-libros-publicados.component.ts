import { Component, OnInit } from '@angular/core';
import {LibroModel} from '../_model/libro.model';
import {Router} from '@angular/router';
import {EditorService} from '../service/editor.service';
import {PublicService} from '../service/public.service';

@Component({
  selector: 'app-public-libros-publicados',
  templateUrl: './public-libros-publicados.component.html',
  styleUrls: ['./public-libros-publicados.component.css']
})
export class PublicLibrosPublicadosComponent implements OnInit {

  libros: LibroModel[];

  constructor(private router: Router, private publicService: PublicService) {

  }

  ngOnInit(): void {
    this.publicService.getColaLibros().then(libros => this.libros = libros);
  }


}
