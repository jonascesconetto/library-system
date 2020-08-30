import { Component, OnInit } from '@angular/core';
import {LibroModel} from '../_model/libro.model';
import {Router} from '@angular/router';
import {PublicService} from '../service/public.service';

@Component({
  selector: 'app-public-search-tematica',
  templateUrl: './public-search-tematica.component.html',
  styleUrls: ['./public-search-tematica.component.css']
})
export class PublicSearchTematicaComponent implements OnInit {

  tematica: string = "";
  libros: LibroModel[];

  constructor(private router: Router, private publicService: PublicService) {
  }

  ngOnInit() {
  }

  private searchTematica() {
    this.publicService.getLibrosPublicByTematica(this.tematica).then(libros => this.libros = libros);
  }

  onSubmit() {
    this.searchTematica();
  }

}
