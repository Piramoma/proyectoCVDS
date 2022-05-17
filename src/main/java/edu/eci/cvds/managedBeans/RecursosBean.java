package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import com.sun.faces.context.AjaxExceptionHandlerImpl;
import edu.eci.cvds.entities.Recurso;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.postgresql.util.PSQLException;
import org.primefaces.component.ajaxexceptionhandler.AjaxExceptionHandler;

import java.io.IOException;
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
    private int idInterno;
    private String description;

    private int idRecursoSeleccionado;

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

    public void setIdInterno(int idInterno) {
        this.idInterno = idInterno;
    }

    public int getIdInterno() {
        return idInterno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void nuevoRecurso() {
        boolean noError = true;
        if (idInterno == 0) { showErrors("Ingresar Idinterno diferente de 0"); noError=false;}
        if (capacidad == 0) { showErrors("Ingresar capacidad diferente de 0"); noError=false;}
        if (estado == null || estado.trim().equals("")  ){showErrors("Completar el campo de estado"); noError=false;}
        if (nombre == null || nombre.trim().equals("")  ){showErrors("Completar el campo de nombre"); noError=false;}
        if (ubicacion == null || ubicacion.trim().equals("")  ){showErrors("Completar el campo de ubicacion"); noError=false;}
        if (tipo == null || tipo.trim().equals("")  ){showErrors("Completar el campo de tipo"); noError=false;}
        if (description == null || description.trim().equals("")  ){showErrors("Completar el campo de descripcion"); noError=false;}

        if (noError){
            try {
                serviciosBiblioteca.nuevoRecurso(idInterno,estado,nombre,ubicacion,tipo,capacidad,description);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
            }catch (PersistenceException e) {
                showErrors(e.getMessage());
            } catch (Exception e) {
                showErrors("Un error inesperado ha ocurrido, estamos trabajando para mejorar");
            }
        }
        idInterno = 0;
        estado = null;
        nombre = "";
        ubicacion = "";
        tipo = null;
        capacidad = 0;
        description = "";
    }

    public void cambiarEstadoRecurso(String redirect){
        try {
            serviciosBiblioteca.cambiarEstadoRecurso(estado,idRecursoSeleccionado);
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirect);
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        } catch (IOException e) {
            showErrors("No hemos podido encontrar la pagina");
        }
    }

    public void seleccionarRecurso(int idRecursoSeleccionadod){
        setIdRecursoSeleccionado(idRecursoSeleccionadod);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin/cambiarEstadoRecurso.xhtml");
        } catch (IOException e) {
            showErrors("No hemos podido encontrar la pagina");
        }
    }

    public void showErrors(String error){
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }

    public int getIdRecursoSeleccionado() {
        return idRecursoSeleccionado;
    }

    public void setIdRecursoSeleccionado(int idRecursoSeleccionado) {
        this.idRecursoSeleccionado = idRecursoSeleccionado;
    }

    public List<Recurso> getTodosLosEquipos(){
        try {
            return serviciosBiblioteca.consultarTodoEquipos();
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        }
        return null;
    }

    public List<Recurso> getTodosLosLibros(){
        try {
            return serviciosBiblioteca.consultarTodoLibros();
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        }
        return null;
    }

    public List<Recurso> getTodasSalasEstudio(){
        try {
            return serviciosBiblioteca.consultarTodoSalasEstudio();
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }
}
