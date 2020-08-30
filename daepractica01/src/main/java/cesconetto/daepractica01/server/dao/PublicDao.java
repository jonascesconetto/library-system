package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Role;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PublicDao {

    /***
     * CRUD
     * */

    Collection<Usuario> getAllUsuarios();

    Usuario getUsuarioByCod(int cod);

    Usuario getUsuarioByEmail(String email);

    Usuario getUsuarioByNombreUsuario(String nombreUsuario);

    /***
     * Loging
     * */

    Usuario login(String nombreUsuario, String contrasena);
}
