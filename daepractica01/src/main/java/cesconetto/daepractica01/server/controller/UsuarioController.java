package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.dao.UsuarioDao;
import cesconetto.daepractica01.server.entity.Usuario;
import cesconetto.daepractica01.server.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private PublicService publicService;

    /** Deletar */
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Usuario> getAllUsuarios(){
        return this.usuarioDao.getAllUsuarios();
    }
    /***/
}
