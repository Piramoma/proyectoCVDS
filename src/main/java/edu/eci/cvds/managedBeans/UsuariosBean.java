package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Usuario;
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

    public List<Usuario> getUsuariosConReservas() {
        return serviciosBiblioteca.consultarUsuariosConReservas();
    }

    public void masInfoReserva(String usuarioReservas) {
        this.usuarioReservas = usuarioReservas;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/misReservas.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsuarioReservas() {
        return usuarioReservas;
    }

}
