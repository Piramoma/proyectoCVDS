package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.io.IOException;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "usuariosBean")
@ApplicationScoped
public class UsuariosBean extends BasePageBean {

    private String usuarioReservas;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public String getUsuarioReservas() {
        return usuarioReservas;
    }

    public void setUsuarioReservas(String usuarioReservas) {
        this.usuarioReservas = usuarioReservas;
    }

    /**
     * Metodo para consultar Usuarios con reservas
     * @return Lista de usuarios
     */
    public List<Usuario> getUsuariosConReservas() {
        try {
            return serviciosBiblioteca.consultarUsuariosConReservas();
        }catch (PersistenceException e){
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para consultar mas informacion de las reservas
     * @param usuarioReservas usuario
     */
    public void masInfoReserva(String usuarioReservas) {
        this.usuarioReservas = usuarioReservas;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/misReservas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para consultar objeto usuaro
     * @param idUsuario id usuario
     * @return Usuario
     */
    public Usuario getUsuario(String idUsuario){
        try {
            return serviciosBiblioteca.consultarNombreUsuario(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
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
