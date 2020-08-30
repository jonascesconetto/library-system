import {RoleModel} from './role.model';

export class UsuarioModel {
  codUsuario: number;
  nombre: string;
  apellido: string;
  fechaNasc: Date;
  email: string;
  nombreUsuario: string;
  contrasena: string;
  roles: RoleModel[];
}
