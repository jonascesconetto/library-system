package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Revisor;
import cesconetto.daepractica01.server.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RoleDao{

    /***
     * CRUD
     * */

    Role getRoleByName(Integer role);
}
