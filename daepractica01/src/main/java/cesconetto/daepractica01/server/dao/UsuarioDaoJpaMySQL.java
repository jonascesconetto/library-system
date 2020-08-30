package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Role;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoJpaMySQL implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Usuario> getAllUsuarios(){

        TypedQuery query = entityManager.createQuery("select u from Usuario u", Usuario.class);

        List<Usuario> users = query.getResultList();

        return users;
    }
}
