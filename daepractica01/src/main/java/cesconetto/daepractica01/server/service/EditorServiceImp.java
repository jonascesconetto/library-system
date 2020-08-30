package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.EditorDao;
import cesconetto.daepractica01.server.dao.LibroAvaliacionDao;
import cesconetto.daepractica01.server.dao.LibroDao;
import cesconetto.daepractica01.server.dao.RevisorDao;
import cesconetto.daepractica01.server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class EditorServiceImp implements EditorService {

    @Autowired
    @Qualifier("libroJpaMySQL")
    private LibroDao libroDao;

    @Autowired
    @Qualifier("editorDaoJpaMySQL")
    private EditorDao editorDao;

    @Autowired
    @Qualifier("revisorDaoJpaMySQL")
    private RevisorDao revisorDao;

    @Autowired
    private LibroAvaliacionDao libroAvaliacionDao;

    /**
     * Editor
     */

//    @Override
//    public void updateEditor(Editor editor){
//    }

    /**
     * EDITOR PARA CON LIBRO
     */

    @Override
    public Collection<Libro> verColaLibrosPendientes(){
        return libroDao.getLibrosColaEditor();
    }

    @Override
    public void aceptarLibro(int codLibro) {

        Libro libro = libroDao.getLibroByCod(codLibro);

        // Buscar os tres revisores com a lista menor e que mais tempo tem sem revisar
        // algum libro ->> fazer um retorno direto da estrutura de dados
//        List<LibroAvaliacion> listaRevisores = libroAvaliacionDao.getRevisoresOciosos(libro.getAutor());
//
//            for (int i = 0; i < listaRevisores.size(); i++) {
//                System.out.println("\n# revisor: " + listaRevisores.get(i).getRevisor().getCodUsuario());
//            }



//        Revisor rA = revisorDao.getRevisorByCod(4);
//        Revisor rB = revisorDao.getRevisorByCod(5);
//        Revisor rC = revisorDao.getRevisorByCod(6);
//
//        LibroAvaliacion rL1 = new LibroAvaliacion();
//        LibroAvaliacion rL2 = new LibroAvaliacion();
//        LibroAvaliacion rL3 = new LibroAvaliacion();
//
//        rL1.setRevisor(rA);
//        rL1.setLibro(libro);
//        rL1.setStatus(LibroAvaliacion.StatusLibroAvaliacion.emRevision);
//
//        rL2.setRevisor(rB);
//        rL2.setLibro(libro);
//        rL2.setStatus(LibroAvaliacion.StatusLibroAvaliacion.emRevision);
//
//        rL3.setRevisor(rC);
//        rL3.setLibro(libro);
//        rL3.setStatus(LibroAvaliacion.StatusLibroAvaliacion.emRevision);
//
//        ArrayList<LibroAvaliacion> listaAvaliacion = new ArrayList<>();
//        listaAvaliacion.add(rL1);
//        listaAvaliacion.add(rL2);
//        listaAvaliacion.add(rL3);
//
//        // Status libro
//        libro.setStatus(Libro.StatusLibro.aceptoEditor);
//
//        // Add Revisors in Revisors list from Libro
//        libro.setRevisores(listaAvaliacion);
//        libroDao.updateLibro(libro);
//
//        // Add Libro in Revisor List
//        rA.setLibrosPiendiente(listaAvaliacion);
//        libroAvaliacionDao.insertLibroAvaliacion(rL1);
//        rB.setLibrosPiendiente(listaAvaliacion);
//        libroAvaliacionDao.insertLibroAvaliacion(rL2);
//        rC.setLibrosPiendiente(listaAvaliacion);
//        libroAvaliacionDao.insertLibroAvaliacion(rL3);

    }

    @Override
    public void rechazarLibro(int codLibro){

        Libro libro = libroDao.getLibroByCod(codLibro);

        /**
         String status,
         List<Revisor> revisores,
         */

        libro.setStatus(Libro.StatusLibro.rechazadoEditor);
        libroDao.updateLibro(libro);
    }

    /**
     * LIBROS PUBLICADOS
     */

}
