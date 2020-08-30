package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class LibroAvaliacionDaoJpaMySQL implements LibroAvaliacionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RevisorDao revisorDao;

    /**
     * CRUD
     * */

    @Override
    public LibroAvaliacion getLibroAvaliacionByCod(Libro codLibro, Revisor codRevisor) {

        TypedQuery<LibroAvaliacion> query = entityManager.createQuery(
                "select lA from LibroAvaliacion lA " +
                        " where lA.libro like '%" + codLibro.getCodLibro() + "%' and "
                        + "lA.revisor like '%" + codRevisor.getCodUsuario() + "%' ",
                LibroAvaliacion.class);

        LibroAvaliacion libroAvaliacion = query.getSingleResult();

        return libroAvaliacion;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void insertLibroAvaliacion(LibroAvaliacion libroAvaliacion){

        entityManager.persist(libroAvaliacion);
    }

    @Override
    public void updateLibroAvaliacion(LibroAvaliacion libroAvaliacion){

        entityManager.merge(libroAvaliacion);
    }

    /**
     * Operaciones
     * */

    @Override
    public Collection<LibroAvaliacion> getLibroRevisores (Libro libro){
        List<LibroAvaliacion> listaLibros = entityManager.createQuery(
                "SELECT lA FROM LibroAvaliacion lA WHERE libro = ?")
                .setParameter(1, libro).getResultList();
        return listaLibros;
    }

    @Override
    public Collection<LibroAvaliacion> getRevisorLibros (Revisor revisor){

        List<LibroAvaliacion> listaRevisores = entityManager.createQuery(
                "SELECT lA FROM LibroAvaliacion lA WHERE revisor =? AND nota = NUll")
                .setParameter(1, revisor).getResultList();

        return listaRevisores;
    }

}
