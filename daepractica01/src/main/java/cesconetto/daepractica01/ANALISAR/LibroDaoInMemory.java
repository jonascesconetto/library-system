//package cesconetto.daepractica01.server.dao;
//
//import cesconetto.daepractica01.server.entity.Libro;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//@Qualifier("libroInMemory")
//public class LibroDaoInMemory implements LibroDao{
//
//    private static Map<Integer, Libro> libros;
//
////    static {
////
////        libros = new HashMap<Integer, Libro>() {
////            {
////                put(1, new Libro(
////                        0,
////                        null,
////                        "Libro 00",
////                        "Tematica Libro 00",
////                        new Date(0000-00-00),
////                        "5",
////                        null,
////                        null)
////                );
////            }
////        };
////    }
//
//    public LibroDaoInMemory() {
//        libros = new TreeMap<>();
//    }
//
//    /**
//     * CRUD
//     */
//    @Override
//    public Collection<Libro> getAllLibros(){
//
//        return this.libros.values();
//    }
//
//    @Override
//    public  Libro getLibroByCod(int cod){
//
//        return this.libros.get(cod);
//    }
//
//    @Override
//    public void insertLibro(Libro libro){
//
//        this.libros.put(libro.getCodLibro(), libro);
//    }
//
//    @Override
//    public void updateLibro(Libro libro){
//
//        Libro l = libros.get(libro.getCodLibro());
//
//        l.setTitulo(libro.getTitulo());
//        l.setTematica(libro.getTematica());
//
//        libros.put(libro.getCodLibro(), libro);
//
//    }
//
//    @Override
//    public void removeLibrorByCod(int cod){
//
//        this.libros.remove(cod);
//    }
//}
