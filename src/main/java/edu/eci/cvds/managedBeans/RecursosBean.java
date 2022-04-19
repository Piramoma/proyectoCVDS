package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.services.ServiciosBiblioteca;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "recursosBean")
@SessionScoped
public class RecursosBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Recurso> getLibros() {
        return serviciosBiblioteca.consultarLibros();
    }

    public List<Recurso> getEquipos() {
        return serviciosBiblioteca.consultarEquipos();
    }

    public List<Recurso> getSalasEstudio() {
        return serviciosBiblioteca.consultarSalasEstudio();
    }

}
