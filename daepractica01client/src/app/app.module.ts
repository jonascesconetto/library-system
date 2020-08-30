import { BrowserModule } from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';

//Route
import {ModuleRoutes} from './app.route';

//Component
import { AppComponent } from './app.component';
import { EditorColaLibrosComponent } from './editor/editor-cola-libros.component';
import {EditorService} from './service/editor.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {AutorService} from './service/autor.service';
import {RevisorService} from './service/revisor.service';
import {PublicService} from './service/public.service';
import { AutorLibrosSubidosComponent } from './autor/autor-libros-subidos.component';
import { AutorSubirLibroComponent } from './autor/autor-subir-libro.component';
import { EditorAceptarLibroComponent } from './editor/editor-aceptar-libro.component';
import { EditorRechazarLibroComponent } from './editor/editor-rechazar-libro.component';
import { RevisorColaLibrosComponent } from './revisor/revisor-cola-libros.component';
import { PublicLibrosPublicadosComponent } from './public/public-libros-publicados.component';
import { PublicSearchTituloComponent } from './public/public-search-titulo.component';
import { PublicSearchTematicaComponent } from './public/public-search-tematica.component';
import { PublicInsertAutorComponent } from './public/public-insert-autor.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PublicInsertRevisorComponent } from './public/public-insert-revisor.component';

@NgModule({
  declarations: [
    AppComponent,
    EditorColaLibrosComponent,
    HomeComponent,
    LoginComponent,
    AutorLibrosSubidosComponent,
    AutorSubirLibroComponent,
    EditorAceptarLibroComponent,
    EditorRechazarLibroComponent,
    RevisorColaLibrosComponent,
    PublicLibrosPublicadosComponent,
    PublicSearchTituloComponent,
    PublicSearchTematicaComponent,
    PublicInsertAutorComponent,
    NavbarComponent,
    PublicInsertRevisorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ModuleRoutes)
  ],
  providers: [
      EditorService,
      AutorService,
      RevisorService,
      PublicService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
