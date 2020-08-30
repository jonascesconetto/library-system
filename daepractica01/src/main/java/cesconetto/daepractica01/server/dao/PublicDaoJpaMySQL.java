package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("usuarioJpaMySQL")
@Transactional//(propagation = Propagation.SUPPORTS, readOnly=true)
public class PublicDaoJpaMySQL implements PublicDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * CRUD
     */

    @Override
    public Collection<Usuario> getAllUsuarios(){

        TypedQuery query = entityManager.createQuery("select u from Usuario u", Usuario.class);

        List<Usuario> usuarios = query.getResultList();

        return usuarios;
    }

    @Override
    public Usuario getUsuarioByCod(int cod){

        return entityManager.find(Usuario.class, cod);
    }

    @Override
    public Usuario getUsuarioByEmail(String email){

        TypedQuery<Usuario> query = entityManager.createQuery(
                "select u from Usuario u " +
                        "where u.email like '%" + email + "%' ",
                Usuario.class);

        Usuario u = query.getSingleResult();

        return u;
    }

    @Override
    public Usuario getUsuarioByNombreUsuario (String nombreUsuario){

        TypedQuery<Usuario> query = entityManager.createQuery(
                "select u from Usuario u " +
                        "where u.nombreUsuario like '%" + nombreUsuario + "%' ",
                Usuario.class);

        Usuario u = query.getSingleResult();

        return u;
    }

    /***
     * Logging
     * */

    @Override
    public Usuario login(String login, String senha) {

        TypedQuery<Usuario> query = entityManager.createQuery(
                "select u from Usuario u " +
                        "where u.nombreUsuario like '%" + login + "%' " +
                        "and u.contrasena like '%" + senha + "%' ",

                Usuario.class);

        Usuario u = query.getSingleResult();

        return u;
    }

}
