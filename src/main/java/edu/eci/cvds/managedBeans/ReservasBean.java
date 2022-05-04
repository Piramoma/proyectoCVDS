package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import edu.eci.cvds.entities.Reserva;
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

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;



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

    private Timestamp fechainicio;

    private Timestamp fechafin;

    private Horario horarioactual;

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
        List<Horario> horarios = serviciosBiblioteca.consultaHorariosRecurso(this.idRecurso);
        System.out.println(" ID " + this.idRecurso);
        System.out.println(" LEN " + horarios.size());
        for (Horario r : horarios){
            event = new DefaultScheduleEvent(r.getRecurso().getTipo() + " - " + r.getRecurso().getNombre(), r.getFechainicio(), r.getFechafin());
            eventModel.addEvent(event);
            event.setId(String.valueOf(r.getId()));
        }
    }

    public void onEventSelect(SelectEvent selectEvent) {
        this.event = (ScheduleEvent) selectEvent.getObject();
        this.eventId = Integer.parseInt(event.getId());
        this.horarioactual = consultarHorario(this.idRecurso,this.eventId);
        this.fechainicio = horarioactual.getFechainicio();
        this.fechafin = horarioactual.getFechafin();
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

}
