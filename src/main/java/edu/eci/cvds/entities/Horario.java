package edu.eci.cvds.entities;


import java.sql.Date;
import java.sql.Timestamp;

public class Horario {
    private int id;
    private int idrecurso;
    private Date fechainicio;
    private String horainicio;
    private Date fechafin;
    private String horafin;

    /**
     * El constructor de Horario toma la franja (con hora inicial y final) en forma de String y la
     * convierte a hora tipo Date.
     */
    public Horario(int id, int idRecurso, Date fechainicio, String horainicio, Date fechafin, String horafin) {
        this.id = id;
        this.idrecurso = idRecurso;
        this.fechainicio = fechainicio;
        this.horainicio = horainicio;
        this.fechafin = fechafin;
        this.horafin = horafin;
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

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", idrecurso=" + idrecurso +
                ", fechainicio=" + fechainicio +
                ", horainicio='" + horainicio + '\'' +
                ", fechafin=" + fechafin +
                ", horafin='" + horafin + '\'' +
                '}';
    }
}