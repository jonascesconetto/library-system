package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.LibroAvaliacionDao;
import cesconetto.daepractica01.server.dao.LibroDao;
import cesconetto.daepractica01.server.dao.RevisorDao;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.LibroAvaliacion;
import cesconetto.daepractica01.server.entity.Revisor;
import cesconetto.daepractica01.server.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RevisorServiceImp implements RevisorService {

    @Autowired
    @Qualifier("libroJpaMySQL")
    private LibroDao libroDao;

    @Autowired
    @Qualifier("revisorDaoJpaMySQL")
    private RevisorDao revisorDao;

    @Autowired
    private LibroAvaliacionDao libroAvaliacionDao;

    /**
     * Revisor
     */
    @Override
    public void updateRevisor(Revisor revisor){

        Collection<Revisor> listaAutoresSistema = revisorDao.getAllRevisores();
        Iterator<Revisor> it = listaAutoresSistema.iterator();

        int ok = 0;

        while (it.hasNext()) {

            Revisor aux = it.next();

            if(revisor.getCodUsuario() != aux.getCodUsuario()) {
                if (aux.getNombreUsuario().equals(revisor.getNombreUsuario())) {
                    System.out.println("->> Nombre de usuario ya existe !!!");
                    ok = 1;
                    break;
                } else {
                    if (aux.getEmail().equals(revisor.getEmail())) {
                        System.out.println("->> Email ya cadastrado !!!");
                        ok = 1;
                        break;
                    }
                }
            }
        }

        if (ok == 0) {

            revisorDao.updateRevisor(revisor);
        }
    }

    /**
     * REVISOR PARA CON LIBROS
     */

    @Override
    public Collection<LibroAvaliacion> verLibrosPendientesRevision(int revisor) {

        Revisor r = revisorDao.getRevisorByCod(revisor);

        //System.out.println("\nTamanho vetor de LibroAvaliacion Revisor: " + libroAvaliacionDao.getRevisorLibros(revisor).size()+"\n");

        return libroAvaliacionDao.getRevisorLibros(r);
    }

    Boolean checkLastRevisorToAssign(Libro libro){
        Collection<LibroAvaliacion> listaLibroRevisores = libroAvaliacionDao.getLibroRevisores(libro);
        Iterator<LibroAvaliacion> it = listaLibroRevisores.iterator();

        //System.out.println("\n# Check dos 3 revisor por libro");

        while (it.hasNext()) {
            LibroAvaliacion aux = it.next();
            if (aux.getNota() == null) {
                //System.out.println("\n# nota parcial [checkLastRevisorToAssign]: " + aux.getNota());
                //System.out.println("\n# Retornou false");
                return false;
            }
        }
        return true;
    }

    Boolean checkNotas(Libro libro){

        Collection<LibroAvaliacion> listaLibroRevisores = libroAvaliacionDao.getLibroRevisores(libro);
        Iterator<LibroAvaliacion> it = listaLibroRevisores.iterator();

        //System.out.println("\n# Check notas dadas al libro");

        while (it.hasNext()) {
            LibroAvaliacion aux = it.next();
            //System.out.println("\n# nota parcial [checkNotas]: " + aux.getNota());
            if (aux.getNota() < 2) {
                //System.out.println("\n# Retornou false");
                return false;
            }
        }
        return true;
    }

    double notaFinalAvaliacion(Libro libro){

        Collection<LibroAvaliacion> listaLibroRevisores = libroAvaliacionDao.getLibroRevisores(libro);
        Iterator<LibroAvaliacion> it = listaLibroRevisores.iterator();

        double notaFinal = 0.0;

        //System.out.println("\n# SOMA notas dadas al libro");

        while (it.hasNext()) {
            LibroAvaliacion aux = it.next();
            if (aux.getNota()!=null) {
                notaFinal+=aux.getNota();
                //System.out.println("\n# nota parcial [notaFinal]: " + notaFinal);
            }
        }
        return notaFinal;
    }

    @Override
    public void revisarLibro(int codLibro, Double nota, Revisor revisor){

        // Busca del objeto Libro
        Libro libro = libroDao.getLibroByCod(codLibro);
        double notaFinal;
        Date hoje = new Date();


        // Trabajando con la funcion de revisar el Libro
        LibroAvaliacion libroAvaliacion = libroAvaliacionDao.getLibroAvaliacionByCod(libro, revisor);

        libroAvaliacion.setNota(nota);
        libroAvaliacion.setStatus(LibroAvaliacion.StatusLibroAvaliacion.revisado);
        libroAvaliacionDao.updateLibroAvaliacion(libroAvaliacion);

        hoje.getTime();
        revisor.setFechaUltimoLibroRevisado(hoje);
        revisorDao.updateRevisor(revisor);

        /** Verificacion de los 3 Revisores por el Librp*/

        if(checkLastRevisorToAssign(libro)) {
            //System.out.println("\n# Deu boa o Teste de verificacion dos 3 revisores");

            // Somo o total das notas
            notaFinal = notaFinalAvaliacion(libro);
            //System.out.println("\n# nota final test: " + notaFinal);

            // check nota Final
            if (notaFinal < 10) {
                libro.setNotaAvaliacion(notaFinal);
                libro.setStatus(Libro.StatusLibro.rechazadoRevisores);
                libroDao.updateLibro(libro);
                //System.out.println("\n# Situacion del Libro [Final]: Rechazado, nota total inferior a 10");
            } else {
                // Check se alguma nota [e menor que 2
                if (checkNotas(libro)) {
                    libro.setNotaAvaliacion(notaFinal);
                    hoje.getTime();
                    libro.setFechaPublicacion(hoje);
                    libro.setStatus(Libro.StatusLibro.publicado);
                    libroDao.updateLibro(libro);
                    //System.out.println("\n# Situacion del Libro [Final]: Acepto");
                } else {
                    libro.setNotaAvaliacion(notaFinal);
                    libro.setStatus(Libro.StatusLibro.rechazadoRevisores);
                    libroDao.updateLibro(libro);
                    //System.out.println("\n# Situacion del Libro [Final]: Rechazado, una nota inferior a 2");
                }
            }
        }else{
            //System.out.println("\n# No deu boa o Teste dos 3 revisores");
        }
    }

    /**
     * LIBROS PUBLICADOS
     */
}
