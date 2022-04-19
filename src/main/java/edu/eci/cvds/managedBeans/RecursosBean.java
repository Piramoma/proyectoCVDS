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
    private Recurso selectedRec;
    private List<Recurso> recursos;
    private List<Recurso> recursosDisponibles;
    private String nombre, ubicacion, tipo, estado,reserva;
    private int capacidad;
    private String horaInicio;
    private String horaFin;

}
