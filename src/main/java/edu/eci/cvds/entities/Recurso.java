package edu.eci.cvds.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Objeto que representa un recurso, este puede ser una sala de estudio, un recurso multimedia o un libro
 * @param id Numero de identificacion de un recurso
 * @param estado String con el estado de un recurso este puede ser "Disponible" o "Dañado"
 * @param ubicacion String con la ubicacion de un recurso
 * @param tipo String que indica de que tipo es un objeto
 * @param capacidad En caso de que el recurso sea una sala de estudio tendra un numero de capacidad maxima, en caso contrario la capacidad del recurso sera 0 por defecto
 * @param horaInicio Hora inical en la que le recurso esta disponible
 * @param horaFin Hora con el ultimo momento en el dia en el que el recurso esta disponible
 * @author LEVIATAN
 */

public class Recurso implements Serializable{

    private int id;
    private int idInterno;
    private String estado;
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;

    public Recurso(int id, int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad) {
        this.id = id;
        this.idInterno = id;
        this.estado = estado;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", idInterno=" + idInterno +
                ", estado='" + estado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}