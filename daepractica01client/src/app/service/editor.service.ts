import { Injectable } from '@angular/core';
import { LibroModel } from '../_model/libro.model';
import {Http, JsonpModule} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class EditorService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) { }

  // verColaLibrosPendientes(): Observable<any> {
  //   return this.http.get('http://localhost:8080/editor')
  //     .map((res => res.json()));
  // }

  private editorUrl = '/editor/libros';

  getColaLibros(): Promise<LibroModel[]> {
    return this.http.get(this.baseUrl + this.editorUrl)
      .toPromise()
      .then(response => response.json() as LibroModel[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
