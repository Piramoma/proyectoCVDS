package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Reservas implements Serializable{
    private int idReserva;
    private int idEstudiante;
    private int idRecurso;
    private Date fechaInicio;
    private Date fechaFinal;

    public Reservas(){
    }

    public Reservas(int idReserva,int idEstudiante,int idRecurso,Date fechaInicio,Date fechaFinal){
        this.idReserva = idReserva;
        this.idEstudiante = idEstudiante;
        this.idRecurso = idRecurso;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    // getters
    public int getIdReserva() {
        return idReserva;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }
    
    // setters
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idEstudiante=" + idEstudiante + ", idRecurso=" + idRecurso + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }
}
