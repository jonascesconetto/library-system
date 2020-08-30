//package cesconetto.daepractica01.server.dao;
//
//import cesconetto.daepractica01.server.entity.Revisor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.TreeMap;
//
//@Repository
//@Qualifier("revisorInMemory")
//public class RevisorDaoInMemory implements RevisorDao{
//
//    private static Map<Integer, Revisor> revisores;
//
////    static {
////
////        revisores = new HashMap<Integer, Revisor>() {
////            {
////              put(1, new Revisor(
////                        0,
////                        "",
////                        "Revisor 0",
////                        "Apellido Revisor 0",
////                        new Date(0000-00-00),
////                        "0@0.com",
////                        "Revisor 0",
////                        "0000",
////                        0,
////                        null,
////                        new Date(0000-00-00))
////                );
////            }
////        };
////    }
//
//    public RevisorDaoInMemory() {
//        revisores = new TreeMap<>();
//    }
//
//    /**
//     * CRUD
//     */
//
//    @Override
//    public Collection<Revisor> getAllRevisores(){
//
//        return this.revisores.values();
//    }
//
//    @Override
//    public Revisor getRevisorByCod(int cod){
//
//        return this.revisores.get(cod);
//    }
//
//    @Override
//    public void insertRevisor(Revisor revisor){
//        this.revisores.put(revisor.getCodUsuario(), revisor);
//    }
//
//    @Override
//    public void updateRevisor(Revisor revisor){
//
//        Revisor r = revisores.get(revisor.getCodUsuario());
//
//        r.setLibrosPiendiente(revisor.getLibrosPiendiente());
//        r.setFechaUltimoLibroRevisado(revisor.getFechaUltimoLibroRevisado());
//
//        revisores.put(revisor.getCodUsuario(), revisor);
//    }
//
//    @Override
//    public void removeRevisorByCod(int cod){
//        this.revisores.remove(cod);
//    }
//}