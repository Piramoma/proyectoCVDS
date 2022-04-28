package edu.eci.cvds.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Objeto de una reserva de un recurso especifico hecha por un usuario registrado
 * @param idUsuario String con el e-mail de un usuario registrado, este e-mail identifica al usuario
 * @param id Numero de identificacion del recurso que el usuario esta reservando
 * @param fechaReserva Fecha actual en la que la reserva esta tomando lugar
 * @param fechaInicioReserva Fecha en la que la reserva comenzara a ser vigente
 * @param fechaFinReserva Fecha en la que la reserva dejara de ser vigente
 * @param estado Booleano que indica si una reserva sigue activa. True si sigue activa False de lo contrario
 * @author LEVIATAN
 */
public class Reserva {
    private int id;
    private String idUsuario;
    private int idRecurso;
    Timestamp fechaInicioReserva,fechaFinReserva;
    Date fechaReserva;
    String estado;

    public Reserva(){
        super();
    }
    public Reserva(int id,String idUsuario, int idRecurso, Timestamp fechaInicioReserva, Timestamp fechaFinReserva, Date fechaReserva, String estado) {
        this.id=id;
        this.idUsuario = idUsuario;
        this.idRecurso = idRecurso;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.fechaReserva=fechaReserva;
        this.estado=estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Timestamp getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(Timestamp fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public Timestamp getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(Timestamp fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String  estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idUsuario='" + idUsuario + '\'' +
                ", idRecurso=" + idRecurso +
                ", fechaInicioReserva=" + fechaInicioReserva +
                ", fechaFinReserva=" + fechaFinReserva +
                ", fechaReserva=" + fechaReserva +
                ", estado=" + estado +
                '}';
    }
}