package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.AutorDao;
import cesconetto.daepractica01.server.dao.LibroDao;
import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AutorServiceImp implements AutorService{

    @Autowired
    @Qualifier("libroJpaMySQL")
    private LibroDao libroDao;

    @Autowired
    @Qualifier("autorJpaMySQL")
    private AutorDao autorDao;

    /**
     * AUTOR
     */

//    @Override
//    public void updateAutor(Autor autor){
//    }

    /**
     * AUTOR PARA CON LIBRO
     */

    /* PESQUISA */
    @Override
    public Collection<Libro> getLibrosSubidosByAutor(int autor){
        Autor a = autorDao.getAutorByCod(autor);
        return libroDao.getLibrosSubidosByAutor(a);
    }

    /* SUBIR */
    @Override
    public void subirLibro(Libro libro, Autor autor){

        libro.setAutor(autor);
        libro.setStatus(Libro.StatusLibro.pendiente);
        libro.setNotaAvaliacion(0.0);
        libroDao.insertLibro(libro);
    }

    /**
     * LIBROS PUBLICADOS
     */

}
