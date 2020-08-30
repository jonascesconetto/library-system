//package cesconetto.daepractica01.server.dao;
//
//import cesconetto.daepractica01.server.entity.Editor;
//import cesconetto.daepractica01.server.entity.Revisor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//@Qualifier("editorInMemory")
//public class EditorDaoInMemory implements EditorDao {
//
//    private static Map<Integer, Editor> editores;
//
////    static {
////
////        editores = new HashMap<Integer, Editor>() {
////            {
////                put(1, new Editor(
////                        0,
////                        "",
////                        "Editor 0",
////                        "General",
////                        new Date(0000-00-00),
////                        "editor@general.com",
////                        "editor",
////                        "1111",
////                        0,
////                        null)
////                );
////            }
////        };
////    }
//
//    public EditorDaoInMemory() {
//        editores = new TreeMap<>();
//    }
//
//    /**
//     * CRUD
//     */
//
//    @Override
//    public Collection<Editor> getAllEditores(){
//
//        return this.editores.values();
//    }
//
//    @Override
//    public Editor getEditorByCod(int cod) {
//
//        return this.editores.get(cod);
//    }
//
//    @Override
//    public void insertEditor(Editor editor){
//        this.editores.put(editor.getCodUsuario(), editor);
//    }
//
//    @Override
//    public void updateEditor(Editor editor){
//
//        Editor e = editores.get(editor.getCodUsuario());
//
//        e.setColaLibros(editor.getColaLibros());
//
//        editores.put(editor.getCodUsuario(),editor);
//    }
//
//    @Override
//    public void removeEditorByCod(int cod){
//        this.editores.remove(cod);
//    }
//
//}
//
//
