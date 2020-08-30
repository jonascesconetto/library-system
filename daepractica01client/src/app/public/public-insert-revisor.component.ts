import { Component, OnInit } from '@angular/core';
import {UsuarioModel} from '../_model/usuario.model';
import {Router} from '@angular/router';
import {PublicService} from '../service/public.service';

@Component({
  selector: 'app-public-insert-revisor',
  templateUrl: './public-insert-revisor.component.html',
  styleUrls: ['./public-insert-revisor.component.css']
})
export class PublicInsertRevisorComponent implements OnInit {

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
    this.publicService.insertRevisor(this.usuario);
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
