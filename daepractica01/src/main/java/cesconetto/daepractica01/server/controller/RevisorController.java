package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.dao.RevisorDao;
import cesconetto.daepractica01.server.entity.LibroAvaliacion;
import cesconetto.daepractica01.server.entity.Revisor;
import cesconetto.daepractica01.server.service.RevisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/revisor")
@CrossOrigin("*")
public class RevisorController {

    @Autowired
    private RevisorService revisorService;

    /**DELETAR*/
    @Autowired
    private RevisorDao revisorDao;
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Revisor> getAllRevisores(){
        return this.revisorDao.getAllRevisores();
    }
    /***/

    @RequestMapping(value = "/{codRevisor}/libros", method = RequestMethod.GET)
    public Collection<LibroAvaliacion> verLibrosPendientesRevision(@PathVariable int codRevisor){
        Collection<LibroAvaliacion> lista = revisorService.verLibrosPendientesRevision(codRevisor);
        return lista;
    }
}