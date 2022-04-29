package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ServiciosBiblioteca;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "usuariosBean")
@ApplicationScoped
public class UsuariosBean extends BasePageBean {

    private String email;
    private String nombre;
    private String apellido;
    private String programa;
    private String contraseña;
    private String tipo;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Usuario> getUsuariosConReservas() {
        return serviciosBiblioteca.consultarUsuariosConReservas();
    }
}
