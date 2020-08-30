import { Component, OnInit } from '@angular/core';
import {LibroModel} from '../_model/libro.model';
import {ActivatedRoute, Router} from '@angular/router';
import {EditorService} from '../service/editor.service';
import {PublicService} from '../service/public.service';

@Component({
  selector: 'app-public-search-titulo',
  templateUrl: './public-search-titulo.component.html',
  styleUrls: ['./public-search-titulo.component.css']
})
export class PublicSearchTituloComponent implements OnInit {

  titulo: string = "";
  libros: LibroModel[];

  constructor(private router: Router, route: ActivatedRoute, private publicService: PublicService) {
    const sprintId$ = route.params
      .map(params => (params['texto'] || "")
        .filter(texto => texto != "")
        .do(texto => {
          console.log("Texto da Pesquisa: " + texto);
          this.titulo = texto;
        }));
  }

  ngOnInit() {
  }

  private searchTitulo() {
    this.publicService.getLibrosPublicByTitulo(this.titulo).then(libros => this.libros = libros);
  }

  onSubmit() {
    this.searchTitulo();
  }

}
