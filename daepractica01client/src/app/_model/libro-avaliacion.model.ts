import {LibroModel} from './libro.model';
import {RevisorModel} from './revisor.model';
import {StatusLibroAvaliacionModel} from './status-libro-avaliacion.model';

export class LibroAvaliacionModel {
  codLibroAvaliacion: number;
  libro: LibroModel;
  revisor: RevisorModel;
  nota: number;
  status: StatusLibroAvaliacionModel;
}
