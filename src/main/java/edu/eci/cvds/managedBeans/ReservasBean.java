package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
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
import java.util.List;
import java.util.Objects;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@ApplicationScoped
public class ReservasBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    private Reserva reservaActual;

    //HORARIO

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    private int eventId = 0;

    private int idRecurso;

    private Timestamp newFechaInicio;

    private Timestamp newFechaFin;

    private Timestamp fechainicio;

    private Timestamp fechafin;

    private Horario horarioactual;

    private Reserva reservaactual;

    private Recurso recursoactual;

    public Timestamp getNewFechaInicio() {
        return newFechaInicio;
    }

    public void setNewFechaInicio(Timestamp newFechaInicio) {
        this.newFechaInicio = newFechaInicio;
    }

    public Timestamp getNewFechaFin() {
        return newFechaFin;
    }

    public void setNewFechaFin(Timestamp newFechaFin) {
        this.newFechaFin = newFechaFin;
    }

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario){
        return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);
    }

    public List<Reserva> consultarReservasPasadas(String idUsuario){
        return serviciosBiblioteca.consultarReservasPasadas(idUsuario);
    }

    public List<Reserva> consultarReservasCanceladas(String idUsuario){
        return serviciosBiblioteca.consultarReservasCanceladas(idUsuario);
    }

    public Horario consultarHorario(int idrecurso, int idhorario) {
        return serviciosBiblioteca.consultarHorario(idrecurso,idhorario);
    }

    public Recurso getRecursoactual() {
        return recursoactual;
    }

    public void setRecursoactual(Recurso recursoactual) {
        this.recursoactual = recursoactual;
    }

    public Reserva getReservaactual() {
        return reservaactual;
    }

    public void setReservaactual(Reserva reservaactual) {
        this.reservaactual = reservaactual;
    }

    public int getReservaActual() {
        return reservaActual.getId();
    }

    public void setReservaActual(Reserva reservaActual) {
        this.reservaActual = reservaActual;
    }

    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Timestamp getFechafin() {
        return fechafin;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Horario getHorarioactual() {
        return horarioactual;
    }

    public void setHorarioactual(Horario horarioactual) {
        this.horarioactual = horarioactual;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void saveIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/verHorarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadEvents() {
        eventModel = new DefaultScheduleModel();
        List<Reserva> horarios = serviciosBiblioteca.listarReservasRecurso(this.idRecurso);
        for (Reserva r : horarios){
            if (Objects.equals(r.getEstado(), "activa")) {
                event = new DefaultScheduleEvent(r.getRecurso().getTipo() + " - " + r.getRecurso().getNombre(), r.getFechaInicioReserva(), r.getFechaFinReserva());
            }
            else {
                event = new DefaultScheduleEvent("Restringido", r.getFechaInicioReserva(), r.getFechaFinReserva());
            }
            eventModel.addEvent(event);
            event.setId(String.valueOf(r.getId()));
        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
        this.reservaactual = serviciosBiblioteca.consultarReserva(this.idRecurso,this.eventId);
        this.fechainicio = reservaactual.getFechaInicioReserva();
        this.fechafin = reservaactual.getFechaFinReserva();
    }

    public boolean isEventRestringido() {
        if (Objects.equals(this.event.getTitle(), "Restringido")) {
            return true;
        }
        else {
            return false;
        }
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void onDateSelect(SelectEvent selectEvent) {
        this.recursoactual = serviciosBiblioteca.consultarRecurso(this.idRecurso);
        this.event = new DefaultScheduleEvent();
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

    public void addEvent(String usuario) {
        ScheduleEvent newEvent = new DefaultScheduleEvent();
        newEvent = new DefaultScheduleEvent(this.recursoactual.getTipo() + " - " + this.recursoactual.getNombre(), event.getStartDate(), event.getEndDate());
        this.eventModel.updateEvent(event);
        Timestamp timeStampInicio = new Timestamp(event.getStartDate().getTime());
        Timestamp timeStampFin = new Timestamp(event.getEndDate().getTime());

        java.util.Date date = event.getStartDate();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);

        serviciosBiblioteca.nuevaReserva(usuario,this.recursoactual.getId(),date1,timeStampInicio,timeStampFin,false,"activa",timeStampInicio);
    }

    public void addEventAdmin(String usuario) {
        ScheduleEvent newEvent = new DefaultScheduleEvent();
        newEvent = new DefaultScheduleEvent("Restringido", event.getStartDate(), event.getEndDate());
        this.eventModel.updateEvent(event);

        Timestamp timeStampInicio = new Timestamp(event.getStartDate().getTime());
        Timestamp timeStampFin = new Timestamp(event.getEndDate().getTime());
        java.util.Date date = event.getStartDate();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);

        serviciosBiblioteca.nuevaReserva(usuario,this.recursoactual.getId(),date1,timeStampInicio,timeStampFin,false,"restringido",timeStampInicio);
    }



}
