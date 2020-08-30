package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.dao.EditorDao;
import cesconetto.daepractica01.server.entity.Editor;
import cesconetto.daepractica01.server.entity.Libro;
import cesconetto.daepractica01.server.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/editor")
@CrossOrigin("*")
public class EditorController {

    @Autowired
    private EditorService editorService;

    /**DELETAR*/
    @Autowired
    private EditorDao editorDao;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Editor> getAllEditores(){
        return this.editorDao.getAllEditores();
    }
    /***/

    @RequestMapping(value = "/libros", method = RequestMethod.GET)
    public Collection<Libro> verColaLibrosPendientes(){
        Collection<Libro> lista = editorService.verColaLibrosPendientes();
        return lista;
    }

    @RequestMapping(value = "/1/{codLibro}", method = RequestMethod.PUT)
    public void aceptarLibro(@PathVariable int codLibro){
        editorService.aceptarLibro(codLibro);
    }

    @RequestMapping(value = "/2/{codLibro}", method = RequestMethod.PUT)
    public void rechazarLibro(@PathVariable int codLibro){
        editorService.rechazarLibro(codLibro);
    }

}
