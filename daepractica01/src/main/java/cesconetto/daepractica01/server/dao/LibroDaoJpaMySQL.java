package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("libroJpaMySQL")
@Transactional
public class LibroDaoJpaMySQL implements LibroDao{

    @PersistenceContext
    private EntityManager entityManager;

    /***
     * CRUD
     * */

    @Override
    @Cacheable("Libros")
    public Collection<Libro> getAllLibros(){
        TypedQuery query = entityManager.createQuery("select l from Libro l", Libro.class);

        List<Libro> libros = query.getResultList();

        return libros;
    }

    @Override
    public Libro getLibroByCod(int cod){

        return entityManager.find(Libro.class, cod);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void insertLibro(Libro libro){
        entityManager.persist(libro);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void updateLibro(Libro libro){

        //entityManager.getTransaction().begin();

        //Libro l = getLibroByCod(libro.getCodLibro());

        //entityManager.lock(l, LockModeType.PESSIMISTIC_WRITE);

        entityManager.merge(libro);

        //entityManager.getTransaction().end();
    }

    @Override
    public void removeLibrorByCod(int cod){

        Libro l = getLibroByCod(cod);

        entityManager.remove(l);
    }

    /**
     * Autor - ok
     * */

    @Override
    public Collection<Libro> getLibrosSubidosByAutor(Autor autorRef){

        List<Libro> libros = entityManager.createQuery("SELECT l FROM Libro l WHERE autor=?")
                .setParameter(1, autorRef).getResultList();
        return libros;
    }

    /**
     * Editor - ok
     * */

    @Override
    public Collection<Libro> getLibrosColaEditor(){

        List<Libro> librosColaEditor = entityManager.createQuery("SELECT l FROM Libro l WHERE status =?")
            .setParameter(1, Libro.StatusLibro.pendiente).getResultList();
        return librosColaEditor;
    }

    /***
     * Public
     * */
    public Collection<Libro> getLibrosTematica(String pesquisa){

        TypedQuery query = entityManager.createQuery("select l from Libro l where status = ? and titulo like ?", Libro.class)
                .setParameter(1, Libro.StatusLibro.publicado).setParameter(2, pesquisa);

        List<Libro> librosPublicadosPesquisado = query.getResultList();

//        List<Libro> libros = entityManager.createQuery("SELECT l FROM Libro l WHERE tematica=?")
//                .setParameter(1, tematica).getResultList();
        return librosPublicadosPesquisado;
    }

    public Collection<Libro> getLibrosTitulo(String pesquisa){

        TypedQuery query = entityManager.createQuery("select l from Libro l where status = ? and titulo like ?", Libro.class)
                .setParameter(1, Libro.StatusLibro.publicado).setParameter(2, pesquisa);

        List<Libro> librosPublicadosPesquisado = query.getResultList();

//        List<Libro> libros = entityManager.createQuery("SELECT l FROM Libro l WHERE titulo=?")
//                .setParameter(1, titulo).getResultList();
        return librosPublicadosPesquisado;
    }

    @Override
    @Cacheable("Libros")
    public Collection<Libro> getLibrosPublicados(){

        TypedQuery query = entityManager.createQuery("select l from Libro l where status = ?", Libro.class)
                .setParameter(1, Libro.StatusLibro.publicado);

        List<Libro> librosPublicados = query.getResultList();

//        List<Libro> librosPublicados = entityManager.createQuery("SELECT l FROM Libro l WHERE status =?")
//                .setParameter(1, Libro.StatusLibro.publicado).getResultList();

        return librosPublicados;
    }
}
