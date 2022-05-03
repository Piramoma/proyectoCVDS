package edu.eci.cvds.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Objeto de una reserva de un recurso especifico hecha por un usuario registrado
 */
public class Reserva {
    private int id;
    private String idUsuario;
    private int idRecurso;
    private Date fechaSolicitud;
    private Timestamp fechaInicioReserva;
    private Timestamp fechaFinReserva;
    private boolean recurrente;
    private String estado;
    private Timestamp diaactual;
    private Timestamp proximaocurrencia;

    private Recurso recurso;

    private Usuario usuario;

    public Reserva(int id, String idUsuario, int idRecurso, Date fechaSolicitud, Timestamp fechaInicioReserva, Timestamp fechaFinReserva, boolean recurrente, Timestamp proximaocurrencia, String estado, Timestamp diaactual) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idRecurso = idRecurso;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.recurrente = recurrente;
        this.proximaocurrencia = proximaocurrencia;
        this.estado = estado;
        this.diaactual = diaactual;
    }

    public Reserva(){
        super();
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

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public Timestamp getProximarecurrencia() {
        return proximaocurrencia;
    }

    public void setProximarecurrencia(Timestamp proximarecurrencia) {
        this.proximaocurrencia = proximarecurrencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getDiaActual() {
        return diaactual;
    }

    public void setDiaActual(Timestamp diaActual) {
        this.diaactual = diaActual;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idUsuario='" + idUsuario + '\'' +
                ", idRecurso=" + idRecurso +
                ", fechaSolicitud=" + fechaSolicitud +
                ", fechaInicioReserva=" + fechaInicioReserva +
                ", fechaFinReserva=" + fechaFinReserva +
                ", recurrente=" + recurrente +
                ", proximarecurrencia=" + proximaocurrencia +
                ", estado='" + estado + '\'' +
                ", diaActual=" + diaactual +
                '}';
    }
}