package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import edu.eci.cvds.services.ServiciosBiblioteca;

import java.sql.Time;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "recursosBean")
@ApplicationScoped
public class RecursosBean extends BasePageBean {

    private String nombre;
    private String ubicacion;
    private String tipo;
    private int capacidad;
    private Time horaInicio;
    private Time horaFin;
    private int id;
    private String estado;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Recurso> getLibros() {
        return serviciosBiblioteca.consultarLibros();
    }

    public List<Recurso> getEquipos() {
        return serviciosBiblioteca.consultarEquipos();
    }

    public List<Recurso> getSalasEstudio() {
        return serviciosBiblioteca.consultarSalasEstudio();
    }

    public void nuevoRecurso(Recurso recurso){

    }

}
