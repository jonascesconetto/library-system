package cesconetto.daepractica01.server.configuration;

import cesconetto.daepractica01.server.entity.Usuario;
import cesconetto.daepractica01.server.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DatosUser implements UserDetailsService {


    @Autowired
    PublicService publicService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = publicService.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException("Sei la meu, deu paul no nome");
        }

        return User.withUsername(email).password("clave").build();
    }
}
