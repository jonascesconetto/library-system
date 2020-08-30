package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    public enum StatusLibro {zero, pendiente, aceptoEditor, rechazadoEditor, publicado, rechazadoRevisores};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libro_id")
    private int codLibro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "tematica")
    private String tematica;

    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaPublicacion;

    @Column(name = "status")
    @Enumerated
    @JsonIgnore
    private StatusLibro status;

    @OneToMany(mappedBy = "libro")
    @JsonIgnore
    private List<LibroAvaliacion> revisores;

    @Column(name = "notaAvaliacion")
    @JsonIgnore
    private Double notaAvaliacion;

    public Libro(){}

    // Getter and Setter
    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public StatusLibro getStatus() {
        return status;
    }

    public void setStatus(StatusLibro status) {
        this.status = status;
    }

    public List<LibroAvaliacion> getRevisores() {
        return revisores;
    }

    public void setRevisores(List<LibroAvaliacion> revisores) {
        this.revisores = revisores;
    }

    public Double getNotaAvaliacion() {
        return notaAvaliacion;
    }

    public void setNotaAvaliacion(Double notaAvaliacion) {
        this.notaAvaliacion = notaAvaliacion;
    }

}