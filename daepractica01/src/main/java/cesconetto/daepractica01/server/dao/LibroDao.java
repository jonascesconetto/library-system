package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Editor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Revisor;

import java.util.Collection;

public interface LibroDao {

    /***
     * CRUD
     * */

    Collection<Libro> getAllLibros();

    Libro getLibroByCod(int cod);

    void insertLibro(Libro libro);

    void updateLibro(Libro libro);

    void removeLibrorByCod(int cod);

    /***
     * Autor
     * */

    Collection<Libro> getLibrosSubidosByAutor(Autor autor);

    /***
     * Editor
     * */

    Collection<Libro> getLibrosColaEditor();

    /***
     * Public
     * */

    Collection<Libro> getLibrosTematica(String tematica);

    Collection<Libro> getLibrosTitulo(String titulo);

    Collection<Libro> getLibrosPublicados();

}
