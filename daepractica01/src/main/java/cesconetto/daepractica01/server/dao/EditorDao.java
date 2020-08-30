package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Editor;

import java.util.Collection;

public interface EditorDao {

    /***
     * CRUD
     * */

    Collection<Editor> getAllEditores();

    Editor getEditorByCod(int cod);

    void insertEditor(Editor editor);

    void updateEditor(Editor editor);

    void removeEditorByCod(int cod);
}
