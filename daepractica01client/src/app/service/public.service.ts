import { Injectable } from '@angular/core';
import {LibroModel} from '../_model/libro.model';
import {UsuarioModel} from '../_model/usuario.model';
import { Headers, Http } from '@angular/http';

@Injectable()
export class PublicService {

  constructor(private http: Http) { }

  private headers = new Headers({ 'Content-Type': 'application/json' });

  private baseUrl = 'http://localhost:8080/public';

  private publicUrl = '/libros';
  private searchTituloUrl = '/1';
  private searchTematicaUrl = '/2';

  private inAutorUrl = '/autor';
  private inRevisorUrl = '/revisor';

  getColaLibros(): Promise<LibroModel[]> {
    return this.http.get(this.baseUrl + this.publicUrl)
      .toPromise()
      .then(response => response.json() as LibroModel[])
      .catch(this.handleError);
  }

  getLibrosPublicByTitulo(titulo: string): Promise<LibroModel[]> {

    return this.http.get(this.baseUrl + this.searchTituloUrl + '/titulo')
      .toPromise()
      .then(response => response.json() as LibroModel[])
      .catch(this.handleError);
  }

  getLibrosPublicByTematica(tematica: string): Promise<LibroModel[]> {

    return this.http.get(this.baseUrl + this.searchTituloUrl + '/tematica')
      .toPromise()
      .then(response => response.json() as LibroModel[])
      .catch(this.handleError);
  }

  insertAutor(user: UsuarioModel): Promise<UsuarioModel> {
    return this.http.post(this.baseUrl + this.inAutorUrl, JSON.stringify({user}), {headers: this.headers})
      .toPromise()
      .then(response => response.json() as UsuarioModel)
      .catch(this.handleError);
  }

  insertRevisor(user: UsuarioModel): Promise<UsuarioModel> {
    return this.http.post(this.baseUrl + this.inRevisorUrl, JSON.stringify({user}), {headers: this.headers})
      .toPromise()
      .then(response => response.json() as UsuarioModel)
      .catch(this.handleError);
  }

  // createBike(bike: Bike): Promise<Bike> {
  //   return this.http
  //     .post(this.bikesUrl, JSON.stringify(bike), {headers: this.headers})
  //     .toPromise()
  //     .then(res => res.json().data as Bike)
  //     .catch(this.handleError);
  // }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
