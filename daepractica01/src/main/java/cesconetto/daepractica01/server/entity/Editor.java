package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Editor extends Usuario{

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "editor_libro",
            joinColumns = @JoinColumn(name = "editor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @JsonIgnore
    private List<Libro> colaLibros;

    public Editor(){}

    // Getter and Setter
    public List<Libro> getColaLibros() {
        return colaLibros;
    }

    public void setColaLibros(List<Libro> colaLibros) {
        this.colaLibros = colaLibros;
    }
}
