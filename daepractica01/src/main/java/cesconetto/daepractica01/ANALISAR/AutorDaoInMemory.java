//package cesconetto.daepractica01.server.dao;
//
//import cesconetto.daepractica01.server.entity.Autor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//@Qualifier("autorInMemory")
//public class AutorDaoInMemory implements AutorDao{
//
//    private static Map<Integer, Autor> autores;
//
////    static {
////        autores = new HashMap<Integer, Autor>() {
////            {
////                put(1, new Autor(
////                        0,
////                        "",
////                        "Autor 0",
////                        "Apellido Autor 0",
////                        new Date(0000-00-00),
////                        "0@0.com",
////                        "Autor 0",
////                        "0000",
////                        0,
////                        null)
////                );
////            }
////        };
////    }
//
//    public AutorDaoInMemory() {
//        autores = new TreeMap<>();
//    }
//
//    /**
//     * CRUD
//     */
//    @Override
//    public Collection<Autor> getAllAutores(){
//        return this.autores.values();
//    }
//
//    @Override
//    public Autor getAutorByCod(int cod) {
//
//       return this.autores.get(cod);
//    }
//
//    @Override
//    public void insertAutor(Autor autor){
//        this.autores.put(autor.getCodUsuario(), autor);
//    }
//
//    @Override
//    public void updateAutor(Autor autor){
//
//        Autor a = autores.get(autor.getCodUsuario());
//
//        a.setLibrosSubidos(autor.getLibrosSubidos());
//
//        autores.put(autor.getCodUsuario(), autor);
//    }
//
//    @Override
//    public void removeAutorByCod(int cod){
//        this.autores.remove(cod);
//    }
//}
//
