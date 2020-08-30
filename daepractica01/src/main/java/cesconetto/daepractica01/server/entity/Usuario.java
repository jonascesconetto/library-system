package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Inheritance( strategy = InheritanceType.JOINED )
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    @JsonIgnore
    private int codUsuario;

    @Column(name = "token")
    @JsonIgnore
    private String token;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    @JsonIgnore
    private String apellido;

    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaNasc;

    @Column(name = "email", nullable = false)
    @JsonIgnore
    private String email;

    @Column(name = "nombre_usuario", nullable = false)
    @JsonIgnore
    private String nombreUsuario;//login

    @Column(name = "contrasena")
    @JsonIgnore
    private String contrasena;//password

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private List<Role> roles;

    public Usuario(){}

    // Getter and Setter
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNasc() {
        return fechaNasc;
    }

    public void setFechaNasc(Date fechaNasc) {
        this.fechaNasc = fechaNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
