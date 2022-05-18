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

    /**
     * Metodo que retorna el Recurso
     * @return Recurso
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * Metodo que cambia el Recurso
     * @param recurso Recurso nuevo
     */
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    /**
     * Constructor de la clase
     */
    public Horario() {
        super();
    }

    /**
     * Metodo que retorna el Id del Horario
     * @return Id
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo que cambia dl Id del Horario
     * @param id Id nuevo
     */
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