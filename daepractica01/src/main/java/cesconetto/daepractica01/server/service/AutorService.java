package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.AutorDao;
import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

public interface AutorService{

    /**
     * AUTOR para con Autor
     */

    //void updateAutor(Autor autor);

    /**
     * AUTOR PARA CON LIBRO Subidos
     */

    /* PESQUISA */
    //Collection<Libro> getAllLibrosSubidosAutor(Autor autor);
    //Collection<Libro> getAllLibrosPublicados();
    //Collection<Libro> getAllLibrosRechazados();
    //Libro getLibroByCod(int cod);

    /* ATUALIZAR */
    //void updateLibro(Libro libro, Autor autor);

    /* REMOVER */
    //void removeLibro(Libro libro, Autor autor);

    /**
     * AUTOR PARA CON LIBRO
     */

    // Busca
    Collection<Libro> getLibrosSubidosByAutor(int autor);

    /* SUBIR */
    void subirLibro(Libro libro, Autor autor);

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
