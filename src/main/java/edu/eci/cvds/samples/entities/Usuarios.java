package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Usuarios implements Serializable{
    private int idUsuario;
    private String nombre;
    private String correo;

    public Usuarios(){
    }

    public Usuarios(int idUsuario,String nombre,String correo){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    // getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    // setters
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
}
