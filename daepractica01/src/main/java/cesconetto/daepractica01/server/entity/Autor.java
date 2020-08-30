package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "autores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Autor extends Usuario implements Serializable{

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Libro> librosSubidos;

    public Autor(){}

    // Getter and Setter
    public List<Libro> getLibrosSubidos() {
        return librosSubidos;
    }

    public void setLibrosSubidos(List<Libro> librosSubidos) {
        this.librosSubidos = librosSubidos;
    }
}