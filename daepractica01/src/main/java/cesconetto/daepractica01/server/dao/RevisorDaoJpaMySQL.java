package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.LibroAvaliacion;
import cesconetto.daepractica01.server.entity.Revisor;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Qualifier("revisorJpaMySQL")
@Transactional
public class RevisorDaoJpaMySQL implements RevisorDao{

    @PersistenceContext
    private EntityManager entityManager;

    /***
     * CRUD
     * */

    @Override
    @Cacheable("Revisor")
    public Collection<Revisor> getAllRevisores(){

        TypedQuery query = entityManager.createQuery("select r from Revisor r", Revisor.class);

        List<Revisor> revisores = query.getResultList();

        return revisores;
    }

    @Override
    @Cacheable("Revisor")
    public Revisor getRevisorByCod(int cod){

        return entityManager.find(Revisor.class, cod);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void insertRevisor(Revisor revisor){

        entityManager.persist(revisor);
    }

    @Override
    public void updateRevisor(Revisor revisor){

        Revisor r = getRevisorByCod(revisor.getCodUsuario());

        entityManager.merge(revisor);
    }

    @Override
    public void removeRevisorByCod(int cod){

        Revisor revisor = getRevisorByCod( cod );

        entityManager.remove( revisor );
    }

}