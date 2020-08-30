package cesconetto.daepractica01.server.dao;

import cesconetto.daepractica01.server.entity.Editor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("editorJpaMySQL")
public class EditorDaoJpaMySQL implements EditorDao{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * CRUD
     */

    @Override
    public Collection<Editor> getAllEditores(){

        TypedQuery query = entityManager.createQuery("select e from Editor e", Editor.class);

        List<Editor> editores = query.getResultList();

        return editores;
    }

    @Override
    public Editor getEditorByCod(int cod) {

        return entityManager.find(Editor.class, cod);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Error.class, readOnly = false)
    public void insertEditor(Editor editor){

        entityManager.persist(editor);
    }

    @Override
    public void updateEditor(Editor editor){
        entityManager.merge(editor);
    }

    @Override
    public void removeEditorByCod(int cod){
        Editor e = getEditorByCod(cod);
        entityManager.remove(e);
    }

}
