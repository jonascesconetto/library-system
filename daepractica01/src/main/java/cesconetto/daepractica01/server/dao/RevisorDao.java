package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.LibroAvaliacion;
import cesconetto.daepractica01.server.entity.Revisor;

import java.util.Collection;
import java.util.List;

public interface RevisorDao {

    /***
     * CRUD
     * */

    Collection<Revisor> getAllRevisores();

    Revisor getRevisorByCod(int cod);

    void insertRevisor(Revisor revisor);

    void updateRevisor(Revisor revisor);

    void removeRevisorByCod(int cod);

//    List<Revisor> getRevisoresOciosos(Autor autor);
}
