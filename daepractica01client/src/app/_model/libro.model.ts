import {AutorModel} from './autor.model';
import {StatusLibroModel} from './status-libro.model';
import {LibroAvaliacionModel} from './libro-avaliacion.model';

export class LibroModel {
  codLibro: number;
  autor: AutorModel;
  titulo: string;
  tematica: string;
  fechaPublicacion: Date;
  status: StatusLibroModel;
  revisores: LibroAvaliacionModel;
  notaAvaliacion: number;
}
