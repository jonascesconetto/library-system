package cesconetto.daepractica01.server.configuration;

import cesconetto.daepractica01.server.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DatosUser datosUser;

    @Autowired
    DataSource dataSource;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService(datosUser);
//        auth.jdbcAuthentication()
//                .passwordEncoder(bCryptPasswordEncoder);

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable();
        httpSecurity.httpBasic();

//        httpSecurity.
//                authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/public/1").permitAll()
//                .antMatchers("/public/2").permitAll()
//                .antMatchers("/public/libros").permitAll()
//                .antMatchers("/public/autor").permitAll()
//                .antMatchers("/public/revisor").permitAll()
//                .antMatchers("/editor/**").hasRole("editor")
//                .antMatchers("/editor").hasRole("editor")
//                .antMatchers("/autor/**").hasRole("autor")
//                .antMatchers("/autor").hasRole("autor")
//                .antMatchers("/revisor/**").hasRole("revisor")
//                .antMatchers("/revisor").hasRole("revisor")
//                .anyRequest()
//                .authenticated().and().csrf().disable().formLogin()
//                .loginPage("/login").failureUrl("/login?error=true")
//                .usernameParameter("editor")
//                .passwordParameter("editor")
//                .and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/").and().exceptionHandling()
//                .accessDeniedPage("/access-denied");

    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//    }
}
