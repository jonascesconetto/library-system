package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

public interface LibroAvaliacionDao {

    /**
     * CRUD
     * */
    LibroAvaliacion getLibroAvaliacionByCod(Libro codLibro, Revisor codRevisor);

    void insertLibroAvaliacion(LibroAvaliacion libroAvaliacion);

    void updateLibroAvaliacion(LibroAvaliacion libroAvaliacion);

    /**
     * Operaciones
     * */

    Collection<LibroAvaliacion> getLibroRevisores (Libro libroAvaliacion);

    Collection<LibroAvaliacion> getRevisorLibros (Revisor libroAvaliacion);

//    List<LibroAvaliacion> getRevisoresOciosos(Autor autor);

}

