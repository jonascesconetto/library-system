import { Routes } from '@angular/router';

import { EditorColaLibrosComponent } from './editor/editor-cola-libros.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {PublicLibrosPublicadosComponent} from './public/public-libros-publicados.component';
import {PublicSearchTituloComponent} from './public/public-search-titulo.component';
import {PublicSearchTematicaComponent} from './public/public-search-tematica.component';
import {PublicInsertAutorComponent} from './public/public-insert-autor.component';
import {PublicInsertRevisorComponent} from './public/public-insert-revisor.component';

export const ModuleRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'editor/libros', component: EditorColaLibrosComponent},

  // {path: 'autor', component: AutorComponent},
  // {path: 'revisor', component: RevisorComponent},

  {path: 'public/libros', component: PublicLibrosPublicadosComponent},
  {path: 'public/1', component: PublicSearchTituloComponent},
  {path: 'public/2', component: PublicSearchTematicaComponent},
  {path: 'public/autor', component: PublicInsertAutorComponent},
  {path: 'public/revisor', component: PublicInsertRevisorComponent}
  //{path: 'login', component: AuthComponent}
];
