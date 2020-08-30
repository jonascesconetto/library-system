import {Component, OnInit} from '@angular/core';
import {LibroModel} from '../_model/libro.model';
import {Router} from '@angular/router';
import {EditorService} from '../service/editor.service';

@Component({
  selector: 'app-editor-cola-libros',
  templateUrl: './editor-cola-libros.component.html',
  styleUrls: ['./editor-cola-libros.component.css']
})
export class EditorColaLibrosComponent implements OnInit {

  libros: LibroModel[];

  constructor(private router: Router, private editorService: EditorService) {

  }

  ngOnInit(): void {
    this.editorService.getColaLibros().then(libros => this.libros = libros);
  }

}
