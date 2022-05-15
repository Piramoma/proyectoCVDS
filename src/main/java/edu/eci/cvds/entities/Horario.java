package edu.eci.cvds.entities;

import java.sql.Timestamp;

public class Horario {
    private int id;
    private int idrecurso;
    private Timestamp fechainicio;
    private Timestamp fechafin;

    private Recurso recurso;

    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la
     * convierte a hora tipo Date.
     */
    public Horario(int id, int idRecurso, Timestamp fechainicio, Timestamp fechafin) {
        this.id = id;
        this.idrecurso = idRecurso;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Horario() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(int idrecurso) {
        this.idrecurso = idrecurso;
    }

    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechafin() {
        return fechafin;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
    }


    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", idrecurso=" + idrecurso +
                ", fechainicio=" + fechainicio +
                ", fechafin=" + fechafin +
                '}';
    }
}