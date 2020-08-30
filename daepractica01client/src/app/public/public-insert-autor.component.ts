import { Component, OnInit } from '@angular/core';
import {AutorModel} from '../_model/autor.model';
import {PublicService} from '../service/public.service';
import {Router} from '@angular/router';
import {UsuarioModel} from '../_model/usuario.model';

@Component({
  selector: 'app-public-insert-autor',
  templateUrl: './public-insert-autor.component.html',
  styleUrls: ['./public-insert-autor.component.css']
})
export class PublicInsertAutorComponent implements OnInit {

  usuario = new UsuarioModel();
  submitted = false;

  constructor(private router: Router, private publicService: PublicService) {}

  ngOnInit() {
  }

  newUsuario(): void {
    this.submitted = false;
    this.usuario = new UsuarioModel();
  }

  private save(): void {
    this.publicService.insertAutor(this.usuario);
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
