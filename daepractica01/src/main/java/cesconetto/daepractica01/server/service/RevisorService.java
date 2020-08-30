package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.EditorDao;
import cesconetto.daepractica01.server.dao.RevisorDao;
import cesconetto.daepractica01.server.entity.Editor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.LibroAvaliacion;
import cesconetto.daepractica01.server.entity.Revisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface RevisorService {

    /**
     * Revisor
     */

    void updateRevisor(Revisor revisor);

    /**
     * REVISOR PARA CON LIBROS
     */

    Collection<LibroAvaliacion> verLibrosPendientesRevision(int revisor);

    void revisarLibro(int codLibro, Double nota, Revisor revisor);

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
