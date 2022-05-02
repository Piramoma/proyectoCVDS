package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.io.IOException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@SessionScoped
public class ReservasBean extends BasePageBean {

    private Reserva reservaActual;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario){
        return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);
    }

    public int getReservaActual() {
        System.out.println("Si llego aqui");
        return reservaActual.getId();
    }

    public void setReservaActual(Reserva reservaActual) {
        this.reservaActual = reservaActual;
        System.out.println(this.reservaActual.getId() + " BEBE");
    }
}
