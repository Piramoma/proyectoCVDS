package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.plaf.TreeUI;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@ApplicationScoped
public class ReservasBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;


    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    public List<Reserva> consultarReservasPasadas(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarReservasPasadas(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    public List<Reserva> consultarReservasCanceladas(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarReservasCanceladas(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    public Horario consultarHorario(int idrecurso, int idhorario) {
        try {
            return serviciosBiblioteca.consultarHorario(idrecurso, idhorario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    public void cancelarReserva(int idRecurso){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/misReservas.xhtml");
            serviciosBiblioteca.cancelarReserva(idRecurso);
        }catch (PersistenceException | IOException e){
            showErrors(e.getMessage());
        }
    }
    public void showErrors(String error) {
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }

}
