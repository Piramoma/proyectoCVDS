package edu.eci.cvds.entities;


import java.sql.Timestamp;

public class Horario {
    private int id;
    private int idrecurso;
    private Timestamp fechainicio;
    private Timestamp fechafin;

    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la
     * convierte a hora tipo Date.
     * @param horaInicio
     * @param horaFin
     */
    public Horario(int id, int idRecurso, Timestamp horaInicio, Timestamp horaFin) {
        this.id = id;
        this.idrecurso = idRecurso;
        this.fechainicio = horaInicio;
        this.fechafin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRecurso() {
        return idrecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idrecurso = idRecurso;
    }

    public Timestamp getHoraInicio() {
        return fechainicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.fechainicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return fechafin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.fechafin = horaFin;
    }

    @Override
    public String toString() {
        return "Disponibilidad{" +
                "id=" + id +
                ", idRecurso=" + idrecurso +
                ", horaInicio=" + fechainicio +
                ", horaFin=" + fechafin +
                '}';
    }
}