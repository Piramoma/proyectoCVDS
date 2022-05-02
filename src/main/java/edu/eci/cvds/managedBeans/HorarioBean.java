package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.sql.Time;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "horarioBean")
@ApplicationScoped
public class HorarioBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Horario> consultarHorarios() {
        return serviciosBiblioteca.consultarHorarios();
    }
}
