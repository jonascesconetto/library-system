package cesconetto.daepractica01.server.controller;

import cesconetto.daepractica01.server.entity.Usuario;
import cesconetto.daepractica01.server.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private PublicService publicService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getContrasena())) {
            return new ResponseEntity<>(new Usuario(), HttpStatus.OK);
        }
//        if (publicService.findByEmail(user.getEmail(), user.getContrasena()) == null){
//            return new ResponseEntity<>(new User(), HttpStatus.OK);
//        }
        return new ResponseEntity<>(publicService.findByEmail(user.getEmail()), HttpStatus.OK);
    }

}
