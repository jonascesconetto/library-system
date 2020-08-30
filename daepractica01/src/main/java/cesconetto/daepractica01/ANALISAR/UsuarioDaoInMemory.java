//package cesconetto.daepractica01.server.dao;
//
//import cesconetto.daepractica01.server.entity.Usuario;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//@Qualifier("usuarioInMemory")
//public class UsuarioDaoInMemory implements PublicDao{
//
//    private static Map<Integer, Usuario> usuarios;
//
//    public UsuarioDaoInMemory() {
//        usuarios = new TreeMap<>();
//    }
//
//    /**
//     * CRUD
//     */
//
//    @Override
//    public Collection<Usuario> getAllUsuarios(){
//        return this.usuarios.values();
//    }
//
//    @Override
//    public Usuario getUsuarioByCod(int cod) {
//        return this.usuarios.get(cod);
//    }
//
//    @Override
//    public Usuario login(String nombreUsuario, String contrasena){
//
//        Usuario x = new Usuario();
//
//        return x;
//    }
//}
