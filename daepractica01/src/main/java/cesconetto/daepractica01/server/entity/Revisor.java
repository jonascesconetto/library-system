package cesconetto.daepractica01.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "revisores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Revisor extends Usuario {

    @OneToMany(mappedBy = "revisor")
    @JsonIgnore
    private List<LibroAvaliacion> librosPiendiente;

    @Temporal(TemporalType.DATE)
    private Date fechaUltimoLibroRevisado;

    public Revisor(){}

    //     Getter and Setter
    public List<LibroAvaliacion> getLibrosPiendiente() {
        return librosPiendiente;
    }

    public void setLibrosPiendiente(List<LibroAvaliacion> librosPiendiente) {
        this.librosPiendiente = librosPiendiente;
    }

    public Date getFechaUltimoLibroRevisado() {
        return fechaUltimoLibroRevisado;
    }

    public void setFechaUltimoLibroRevisado(Date fechaUltimoLibroRevisado) {
        this.fechaUltimoLibroRevisado = fechaUltimoLibroRevisado;
    }
}