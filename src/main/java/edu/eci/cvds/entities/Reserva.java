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
    private Timestamp proximaocurrencia;
    private String estado;
    private Timestamp diaActual;

    private Recurso recurso;

    private Usuario usuario;


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
        return diaActual;
    }

    public void setDiaActual(Timestamp diaActual) {
        this.diaActual = diaActual;
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
                ", diaActual=" + diaActual +
                '}';
    }
}