package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Usuario;

import java.util.Collection;

public interface PublicService {

    /**
     * PUBLIC PARA CON USUARIOS
     */

    // Login
    //Usuario loggin(String login, String password);
    Usuario findByEmail(String email);

    Usuario findByNombreUsuario(String nombreUsuario);

    // Registrar Usuario (AUTOR/REVISOR)
    void insertUsuario(Usuario usuario, int tipo);

    void insertAutor(Usuario usuario);

    void insertRevisor(Usuario usuario);

    /**
     * LIBROS PUBLICADOS
     */


    Collection<Libro> searchByTitulo(String titulo);

    Collection<Libro> searchByTematica(String tematica);

    // Ver Libros Publicados
    Collection<Libro> getAllLibrosPublicados();

    /*
    // Download
    Libro downloadLibro(int codLibro);
    */

}
