package edu.eci.cvds.entities;

import java.io.Serializable;

/**
 * Usuario registrado en la plataforma de la biblioteca, el usuario puede pertenecer a la comunidad o puede ser un administrador de la
 * plataforma. Un usuario de la comunidad puede ver los recursos de la biblioteca y reservarlos si esta registrado mientras que un
 * Administrador de la plataforma puede añadir recursos, cambiar el estado de los recursos y consultar reportes acerca del comportamiento
 * de las reservas
 * @param email String con el correo electronico de la persona registrada. El correo electronico identifica a un usuario
 * @param nombre String con nombre de la persona registrada en la plataforma de la biblioteca
 * @param apellido String con el apellido de la persona registrada en la plataforma de la biblioteca
 * @param programa Tipo de usuario de la plataforma este puede ser 1 para Comunidad o 2 para Admisitrador
 * @param contraseña Tipo de usuario de la plataforma este puede ser 1 para Comunidad o 2 para Admisitrador
 * @param tipo Tipo de usuario de la plataforma este puede ser 1 para Comunidad o 2 para Admisitrador
 * @author AlejandroB
 */
public class Usuario implements Serializable{
    private String email;
    private String nombre;
    private String apellido;
    private String programa;
    private String contraseña;
    private String tipo;
    private long numReservas;

    public Usuario(String email,String nombre, String apellido, String programa, String contraseña, String tipo){
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public Usuario(String email,String nombre, String apellido, String programa, long numReservas){
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
        this.numReservas = numReservas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(long numReservas) {
        this.numReservas = numReservas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", programa='" + programa + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", tipo='" + tipo + '\'' +
                ", NumeroReservasActivas='" + numReservas + '\'' +
                '}';
    }
}