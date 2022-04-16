package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Devoluciones implements Serializable{
    private int idDevolucion;
    private int idRecurso;
    private Date fechaDevolucion;

    public Devoluciones(){
    }

    public Devoluciones(int idDevolucion,int idRecurso,Date fechaDevolucion){
        this.idDevolucion = idDevolucion;
        this.idRecurso = idRecurso;
        this.fechaDevolucion = fechaDevolucion;
    }

    // getters
    public int getIdDevolucion() {
        return idDevolucion;
    }

    public int getIdRecurso() {
        return idRecurso;
    }
    
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
    
    // setters
    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }
    
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Devolucion{" + "idDevolucion=" + idDevolucion + ", idRecurso=" + idRecurso + ", fechaDevolucion=" + fechaDevolucion + '}';
    }
}
