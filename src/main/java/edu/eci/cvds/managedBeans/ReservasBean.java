package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ServiciosBiblioteca;
import edu.eci.cvds.services.exception.ServicesException;
import org.primefaces.PrimeFaces;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.IOException;
import java.util.Objects;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@ApplicationScoped
public class ReservasBean extends BasePageBean {

    private Reserva reservaActual;

    private String tipoHistorial;

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario){
        return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);
    }

    public List<Reserva> consultarReservasPasadas(String idUsuario){
        return serviciosBiblioteca.consultarReservasPasadas(idUsuario);
    }

    public List<Reserva> consultarReservasCanceladas(String idUsuario){
        return serviciosBiblioteca.consultarReservasCanceladas(idUsuario);
    }

    public int getReservaActual() {
        return reservaActual.getId();
    }

    public void setReservaActual(Reserva reservaActual) {
        this.reservaActual = reservaActual;
    }


    //HORARIOS

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    private int eventId = 0;

    public void loadEvents() throws ServicesException {
        eventModel = new DefaultScheduleModel();
        List<Horario> horarios = serviciosBiblioteca.consultaHorariosRecurso(1);
        for (Horario r : horarios){
            event = new DefaultScheduleEvent(r.getRecurso().getTipo() + " - " + r.getRecurso().getNombre(), r.getFechainicio(), r.getFechafin());
            eventModel.addEvent(event);
            event.setId(String.valueOf(r.getId()));
        }
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
