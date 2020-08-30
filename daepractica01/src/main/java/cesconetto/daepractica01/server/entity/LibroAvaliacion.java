package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "libro_avaliacion")
public class LibroAvaliacion {

    public enum StatusLibroAvaliacion {emRevision, revisado};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libro_avaliacion_id")
    private int codLibroAvaliacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "revisor_id")
    @JsonIgnore
    private Revisor revisor;

    @Column(name = "nota")
    private Double nota;

    @Column(name = "status")
    @Enumerated
    private StatusLibroAvaliacion status;

    public LibroAvaliacion(){}

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public StatusLibroAvaliacion getStatus() {
        return status;
    }

    public void setStatus(StatusLibroAvaliacion status) {
        this.status = status;
    }
}
