package cesconetto.daepractica01.server.service;

import cesconetto.daepractica01.server.dao.*;
import cesconetto.daepractica01.server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PublicServiceImp implements PublicService {

    @Autowired
    @Qualifier("libroJpaMySQL")
    private LibroDao libroDao;

    @Autowired
    @Qualifier("usuarioJpaMySQL")
    private PublicDao publicDao;

    @Autowired
    @Qualifier("autorJpaMySQL")
    private AutorDao autorDao;

    @Autowired
    @Qualifier("revisorJpaMySQL")
    private RevisorDao revisorDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * PUBLIC PARA CON USUARIOS
     */

    @Override
    public Usuario findByEmail(String email) {

        return publicDao.getUsuarioByEmail(email);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) {

        return publicDao.getUsuarioByNombreUsuario(nombreUsuario);
    }

    // Registrar Usuario (AUTOR/REVISOR)
    /**REFATORAR*/
    @Override
    public void insertUsuario(Usuario usuario, int tipo) {
//
//        Collection<Usuario> listaUsuariosSistema = publicDao.getAllUsuarios();
//        Iterator<Usuario> it = listaUsuariosSistema.iterator();
//
//        int ok = 0;
//
//        while (it.hasNext()) {
//
//            Usuario aux = it.next();
//
//            if (aux.getNombreUsuario().equals(usuario.getNombreUsuario())) {
//                System.out.println("->> Nombre de usuario ya existe !!!");
//                ok = 1;
//                break;
//            }else {
//                if (aux.getEmail().equals(usuario.getEmail())) {
//                    System.out.println("->> Email ya cadastrado !!!");
//                    ok = 1;
//                    break;
//                }
//            }
//        }
//
//        // Add User and Type
//        if (tipo == 1 && ok == 0) {
//            Autor a = new Autor();
//            a.setNombre(usuario.getNombre());
//            a.setApellido(usuario.getApellido());
//            a.setEmail(usuario.getEmail());
//            a.setNombreUsuario(usuario.getNombreUsuario());
//            a.setContrasena(usuario.getContrasena());
//            a.setFechaNasc(usuario.getFechaNasc());
//
//            List<Libro> libroAutor = new ArrayList<>();
//            a.setLibrosSubidos(libroAutor);
//
//            Role role = roleDao.getRoleByName(2);
//            List<Role> listRole= new ArrayList<>();
//            listRole.add(role);
//            a.setRoles(listRole);
//
//            autorDao.insertAutor(a);
//        } else {
//            if (tipo == 2 && ok == 0) {
//                Revisor r = new Revisor();
//                r.setNombre(usuario.getNombre());
//                r.setApellido(usuario.getApellido());
//                r.setEmail(usuario.getEmail());
//                r.setNombreUsuario(usuario.getNombreUsuario());
//                r.setContrasena(usuario.getContrasena());
//                r.setFechaNasc(usuario.getFechaNasc());
//
//                List<Libro> libroRevisor = new ArrayList<>();
//                //r.setLibrosPiendiente(libroRevisor);
//
//                Date hoje = new Date();
//                r.setFechaUltimoLibroRevisado(hoje);
//
//                Role role = roleDao.getRoleByName(3);
//                List<Role> listRole= new ArrayList<>();
//                listRole.add(role);
//                r.setRoles(listRole);
//
//                revisorDao.insertRevisor(r);
//            }
//        }
    }

    public boolean testUserInDB(Usuario usuario) {

        Usuario testEmail = publicDao.getUsuarioByEmail(usuario.getEmail());
        Usuario testNombreUsuario = publicDao.getUsuarioByNombreUsuario(usuario.getNombreUsuario());

        if (usuario.getEmail() == testEmail.getEmail()) {
            return false;
        }else {
            if (usuario.getNombreUsuario() == testNombreUsuario.getNombreUsuario()) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public void insertAutor(Usuario usuario){

//        System.out.println("Antes inserir usuario autor");
//        if(usuario.getEmail() == testEmail.getEmail() || usuario.getNombreUsuario() == testNombreUsuario.getNombreUsuario()){
//            System.out.println("Validacao de Usuario Autor en el DB nao deu boa");
//        }else{
            Autor a = new Autor();
            a.setNombre(usuario.getNombre());
            a.setApellido(usuario.getApellido());
            a.setEmail(usuario.getEmail());
            a.setNombreUsuario(usuario.getNombreUsuario());
            a.setContrasena(usuario.getContrasena());
            a.setFechaNasc(usuario.getFechaNasc());
            // List Books
            List<Libro> libroAutor = new ArrayList<>();
            a.setLibrosSubidos(libroAutor);
            // Role
            Role role = roleDao.getRoleByName(2);
            List<Role> listRole= new ArrayList<>();
            listRole.add(role);
            a.setRoles(listRole);
            //save
            autorDao.insertAutor(a);
//        }
    }

    @Override
    public void insertRevisor(Usuario usuario){

       //if(testUserInDB(usuario)){
            Revisor r = new Revisor();
            r.setNombre(usuario.getNombre());
            r.setApellido(usuario.getApellido());
            r.setEmail(usuario.getEmail());
            r.setNombreUsuario(usuario.getNombreUsuario());
            r.setContrasena(usuario.getContrasena());
            r.setFechaNasc(usuario.getFechaNasc());

            //List Book
            //List<Libro> libroRevisor = new ArrayList<>();
            //r.setLibrosPiendiente(libroRevisor);

            //Last book check
            Date hoje = new Date();
            r.setFechaUltimoLibroRevisado(hoje);

            // Roles
            Role role = roleDao.getRoleByName(3);
            List<Role> listRole= new ArrayList<>();
            listRole.add(role);
            r.setRoles(listRole);

            // save
            revisorDao.insertRevisor(r);
//        }else{
//            System.out.println("Validacao de Usuario Revisor en el DB");
//        }
    }

    /**
     * Login and Registration
     */

//     Login
//    @Override
//    public Usuario loggin(String nombreUsuario, String contrasena) {
//
//        Usuario logado = publicDao.login(nombreUsuario, contrasena);
//        return logado;
//    }

    /**
     * PUBLIC PARA CON LIBRO
     */

    @Override
    public Collection<Libro> searchByTitulo(String titulo){

        return libroDao.getLibrosTitulo(titulo);
    }

    @Override
    public Collection<Libro> searchByTematica(String tematica){

        return libroDao.getLibrosTematica(tematica);
    }

    @Override
    public Collection<Libro> getAllLibrosPublicados(){

        return libroDao.getLibrosPublicados();
    }

}