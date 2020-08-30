package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Role;
import cesconetto.daepractica01.server.entity.Usuario;

import java.util.Collection;

public interface UsuarioDao {

    Collection<Usuario> getAllUsuarios();
}
