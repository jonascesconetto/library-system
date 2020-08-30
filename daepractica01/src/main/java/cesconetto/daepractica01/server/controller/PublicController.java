package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.entity.Usuario;
import cesconetto.daepractica01.server.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Collection;

@RestController
@RequestMapping("/public")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin
public class PublicController {

    @Autowired
    private PublicService publicService;

    @RequestMapping(value = "/libros", method = RequestMethod.GET)
    public Collection<Libro> getAllLibrosPublicados(){
        Collection<Libro> lista = publicService.getAllLibrosPublicados();
        return lista;
    }

    @RequestMapping(value = "/1/{pesquisa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Libro> searchByTitulo(@PathVariable String pesquisa){
        Collection<Libro> lista = publicService.searchByTitulo(pesquisa);
        return lista;
    }

    @RequestMapping(value = "/2/{pesquisa}", method = RequestMethod.GET)
    public Collection<Libro> searchByTematica(@PathVariable String pesquisa) {

        Collection<Libro> lista = publicService.searchByTematica(pesquisa);
        return lista;
    }

    // inserir autor
    // consumes = MediaType.APPLICATION_JSON_VALUE
    @RequestMapping(value = "/autor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveAutor (@RequestBody Usuario user) {
        publicService.insertAutor(user);
    }

    // inserir revisor
    @RequestMapping(value = "/revisor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveRevisor (@RequestBody Usuario user) {
        publicService.insertRevisor(user);
    }
}
