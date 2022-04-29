package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@SessionScoped
public class ReservasBean extends BasePageBean {

    private int id;
    private String idUsuario;
    private int idRecurso;
    Timestamp fechaInicioReserva,fechaFinReserva;
    Date fechaReserva;
    String estado;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario){return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);}

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario){return serviciosBiblioteca.consultarPorUsuarioMuchaInfo(idUsuario);}

}
