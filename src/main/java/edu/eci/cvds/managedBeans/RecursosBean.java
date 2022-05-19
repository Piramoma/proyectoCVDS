package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.sql.Time;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "recursosBean")
@SessionScoped
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

    public int getIdRecursoSeleccionado() {
        return idRecursoSeleccionado;
    }

    public void setIdRecursoSeleccionado(int idRecursoSeleccionado) {
        this.idRecursoSeleccionado = idRecursoSeleccionado;
    }

    /**
     * Metodo para listar Equipos
     * @return lista de Equipos
     */
    public List<Recurso> getTodosLosEquipos(){
        try {
            return serviciosBiblioteca.consultarTodoEquipos();
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para listar Libros
     * @return lista de Libros
     */
    public List<Recurso> getTodosLosLibros(){
        try {
            return serviciosBiblioteca.consultarTodoLibros();
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para listar Salas de Estudio
     * @return lista de Salas de Estudio
     */
    public List<Recurso> getTodasSalasEstudio(){
        try {
            return serviciosBiblioteca.consultarTodoSalasEstudio();
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para añadir un nuevo recurso
     */
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

    /**
     * Metodo para cambiar estado de recurso
     * @param redirect pagina a reidreccionar
     */
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

    /**
     * Metodo para selecionar un recurso
     * @param idRecursoSeleccionadod id
     */
    public void seleccionarRecurso(int idRecursoSeleccionadod){
        setIdRecursoSeleccionado(idRecursoSeleccionadod);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/admin/cambiarEstadoRecurso.xhtml");
        } catch (IOException e) {
            showErrors("No hemos podido encontrar la pagina");
        }
    }

    /**
     * Metodo para mostrar errores en pantalla
     * @param error erroes
     */
    public void showErrors(String error){
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }
}
