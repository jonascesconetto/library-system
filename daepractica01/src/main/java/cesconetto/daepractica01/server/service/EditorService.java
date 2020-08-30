package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.EditorDao;
import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Editor;
import cesconetto.daepractica01.server.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface EditorService{

    /**
     * Editor
     */

//    void updateEditor(Editor editor);

    /**
     * EDITOR PARA CON LIBROS
     */

    Collection<Libro> verColaLibrosPendientes();

    void aceptarLibro(int codLibro);

    void rechazarLibro(int codLibro);

    /**
     * LIBROS PUBLICADOS
     */
    /*
    Collection<Libro> searchByTitulo(String titulo);

    Collection<Libro> searchByTematica(String tematica);

    // Ver Libros Publicados
    Collection<Libro> getAllLibrosPublicados();

    // Download
    Libro downloadLibro(int codLibro);
    */
}
