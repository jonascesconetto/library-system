package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Revisor;

import java.util.Collection;

public interface AutorDao {

    /***
     * CRUD
     * */

    Collection<Autor> getAllAutores();

    Autor getAutorByCod(int cod);

    void insertAutor(Autor autor);

    void updateAutor(Autor autor);

    void removeAutorByCod(int cod);
}
