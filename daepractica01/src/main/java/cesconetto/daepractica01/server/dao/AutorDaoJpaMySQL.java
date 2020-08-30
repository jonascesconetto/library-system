package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("autorJpaMySQL")
@Transactional
public class AutorDaoJpaMySQL implements AutorDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * CRUD
     */

    @Override
    public Collection<Autor> getAllAutores(){

        TypedQuery query = entityManager.createQuery("select a from Autor a", Autor.class);

        List<Autor> autores = query.getResultList();

        return autores;
    }

    @Override
    public Autor getAutorByCod(int cod) {
        return entityManager.find(Autor.class, cod);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void insertAutor(Autor autor){
        entityManager.persist(autor);
    }

    @Override
    public void updateAutor(Autor autor){
        entityManager.merge(autor);
    }

    @Override
    public void removeAutorByCod(int cod){
        Autor autor = getAutorByCod( cod );
        entityManager.remove( autor );
    }

}
