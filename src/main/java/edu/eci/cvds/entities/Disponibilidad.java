package edu.eci.cvds.entities;

import java.sql.Time;

public class Disponibilidad {
    private int id;
    private int idRecurso;
    private Time horaInicio;
    private Time horaFin;


    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la
     * convierte a hora tipo Date.
     * @param horaInicio
     * @param horaFin
     */
    public Disponibilidad(int id, int idRecurso, Time horaInicio, Time horaFin) {
        this.id = id;
        this.idRecurso = idRecurso;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Disponibilidad{" +
                "id=" + id +
                ", idRecurso=" + idRecurso +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}