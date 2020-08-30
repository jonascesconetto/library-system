package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.dao.AutorDao;
import cesconetto.daepractica01.server.entity.Autor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/autor")
@CrossOrigin("*")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private AutorDao autorDao;

    /**DELETAR*/
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Autor> getAllAutores(){
        return this.autorDao.getAllAutores();
    }
    /***/

    @RequestMapping(value = "/{codAutor}/libros", method = RequestMethod.GET)
    public Collection<Libro> getLibrosSubidosByAutor(@PathVariable int codAutor){
        Collection<Libro> lista = autorService.getLibrosSubidosByAutor(codAutor);
        return lista;
    }

    @RequestMapping(value = "/{codAutor}libros", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subirLibro(@PathVariable int codAutor, @RequestBody Libro libro){

        Autor autor = autorDao.getAutorByCod(codAutor);
        autorService.subirLibro(libro, autor);
    }
}

