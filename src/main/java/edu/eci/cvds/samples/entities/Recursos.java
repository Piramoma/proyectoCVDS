package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Recursos implements Serializable{
    private int idRecurso;
    private String nombre;
    private boolean disponible;
    private String tipo;
    private String descripcion;
    private String ubicacion;
    private int capacidad;

    public Recursos(){
    }

    public Recursos(int idRecurso,String nombre,boolean disponible,String tipo,String descripcion,String ubicacion,int capacidad){
        this.idRecurso = idRecurso;
        this.nombre = nombre;
        this.disponible = disponible;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    // getters
    public int getIdRecurso() {
        return idRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // setters
    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Recurso{" + "idRecurso=" + idRecurso + ", nombre=" + nombre + ", disponible=" + disponible + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
}
