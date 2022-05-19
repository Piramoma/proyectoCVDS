package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@SuppressWarnings("deprecation")
@ManagedBean(name = "calendarioBean")
@ApplicationScoped
public class CalendarioBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;

    private int idRecurso;

    private ScheduleModel eventModel = new DefaultScheduleModel();

    private ScheduleEvent event = new DefaultScheduleEvent();

    private ScheduleEvent eventAux = new DefaultScheduleEvent();

    private int eventId = 0;

    private Timestamp newFechaInicio;

    private Timestamp newFechaFin;

    private Timestamp fechainicio;

    private Timestamp fechafin;

    private Horario horarioactual;

    private Reserva reservaactual;

    private Recurso recursoactual;

    private java.util.Date fechaDiaSeleccionado;

    private String selectedHourStart;

    private String selectedHourEnd;


    /**
     * Metodo para inicializar el horario de los recursos
     * @param idRecurso id del Recurso elegido
     */
    public void inicializarHorario(int idRecurso) {
        this.idRecurso = idRecurso;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/verHorarios.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que carga los eventos del recurso seleccionado
     */
    public void loadEvents() {
        try {
            eventModel = new DefaultScheduleModel();
            List<Reserva> horarios = serviciosBiblioteca.listarReservasRecurso(this.idRecurso);
            for (Reserva r : horarios) {
                if (Objects.equals(r.getEstado(), "activa")) {
                    event = new DefaultScheduleEvent("Reserva Activa", r.getFechaInicioReserva(), r.getFechaFinReserva());
                    eventModel.addEvent(event);
                    event.setId(String.valueOf(r.getId()));
                }
                if (Objects.equals(r.getEstado(), "restringido")) {
                    event = new DefaultScheduleEvent("HorarioRestringido", r.getFechaInicioReserva(), r.getFechaFinReserva());
                    eventModel.addEvent(event);
                    event.setId(String.valueOf(r.getId()));
                }
            }
        }catch (Exception e){
            showErrors(e.getMessage());
        }
    }


    /**
     * Metodo que muestra la informacion del evento clickleado
     * @param selectEvent Evento seleccionado
     */
    public void onEventSelect(SelectEvent selectEvent) {
        try {
            this.event = (ScheduleEvent) selectEvent.getObject();
            this.eventId = Integer.parseInt(event.getId());
            this.reservaactual = serviciosBiblioteca.consultarReserva(this.idRecurso, this.eventId);
            this.fechainicio = reservaactual.getFechaInicioReserva();
            this.fechafin = reservaactual.getFechaFinReserva();
        }catch (Exception e){
            showErrors(e.getMessage());
        }
    }

    /**
     * Metodo que me dice si el horario esta restringido o no
     * @return String que representa estado evento
     */
    public boolean isEventRestringido() {
        if (Objects.equals(this.event.getTitle(), "HorarioRestringido")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para seleccionado la fecha del evento
     * @param selectEvent Fecha Seleccionada
     */
    public void onDateSelect(SelectEvent selectEvent) {
        try {
            this.recursoactual = serviciosBiblioteca.consultarRecurso(this.idRecurso);
            this.event = new DefaultScheduleEvent();
            java.util.Date date = (java.util.Date) selectEvent.getObject();
            fechaDiaSeleccionado = new Date(date.getTime() + (1000 * 60 * 60 * 24));
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
    }

    /**
     * Metodo para que la comunidad añada un evento nuevo
     * @param usuario Usuario que quiere hacer el evento
     */
    public void addEvent(String usuario) throws ParseException, PersistenceException {
        //Horas Seleecionadas
        String[] hourStart = selectedHourStart.split(":");
        String[] hourEnd = selectedHourEnd.split(":");
        //Fecha Actual
        LocalDate localDateHoy = LocalDate.now();
        java.sql.Date dateHoy = Date.valueOf(localDateHoy);
        Timestamp timestampHoy = new Timestamp(dateHoy.getTime());
        //Timestamp Evento
        Timestamp timestampStart = new Timestamp(fechaDiaSeleccionado.getYear(),fechaDiaSeleccionado.getMonth(),fechaDiaSeleccionado.getDate(),Integer.parseInt(hourStart[0]),0,0,0);
        Timestamp timestampEnd = new Timestamp(fechaDiaSeleccionado.getYear(),fechaDiaSeleccionado.getMonth(),fechaDiaSeleccionado.getDate(),Integer.parseInt(hourEnd[0]),0,0,0);
        Date dateStart = new Date(timestampStart.getTime());
        Date dateEnd = new Date(timestampEnd.getTime());
       if (errors(hourStart,hourEnd,dateStart,dateEnd,dateHoy)){
           ScheduleEvent newEvent = new DefaultScheduleEvent("Reserva Activa", dateStart, dateEnd);
           this.eventModel.updateEvent(newEvent);
           try {
               serviciosBiblioteca.nuevaReserva(usuario, this.recursoactual.getId(), dateHoy, timestampStart, timestampEnd, false, "activa", timestampHoy);
           } catch (PersistenceException e) {
               showErrors(e.getMessage());
           }
        }
    }

    /**
     * Metodo para verificar errores cuando se va añadir un evento
     * @return
     */
    private boolean errors(String[] hourStart, String[] hourEnd,Date dateStart,Date dateEnd, Date dateHoy) throws PersistenceException {
        boolean isError = true;
        if (Integer.parseInt(hourStart[0]) > Integer.parseInt(hourEnd[0]))
        { showErrors("La Hora Final Debe ser mayor a la Hora Inicial");
            isError=false;
        }
        else if (Integer.parseInt(hourStart[0]) == Integer.parseInt(hourEnd[0]))
        { showErrors("La Hora Final Debe ser diferente la Hora Inicial");
            isError=false;
        }
        else if ((Integer.parseInt(hourEnd[0]) - Integer.parseInt(hourStart[0])) > 2)
        { showErrors("La Reservas tienen un maximo de dos Horas");
            isError=false;
        }
        else if ((dateStart).getTime() < (dateHoy).getTime()) {
            showErrors("La Fecha de la Reserva debe ser mayor o igual a la Fecha actual");
            isError=false;
        }

        return isError;
    }


    /**
     * Metodo para que la comunidad añada un evento nuevo
     * @param usuario Usuario que quiere hacer el evento
     */
    public void addEventAdmin(String usuario) throws ParseException, PersistenceException {
        //Horas Seleecionadas
        String[] hourStart = selectedHourStart.split(":");
        String[] hourEnd = selectedHourEnd.split(":");
        //Fecha Actual
        LocalDate localDateHoy = LocalDate.now();
        java.sql.Date dateHoy = Date.valueOf(localDateHoy);
        Timestamp timestampHoy = new Timestamp(dateHoy.getTime());
        //Timestamp Evento
        Timestamp timestampStart = new Timestamp(fechaDiaSeleccionado.getYear(),fechaDiaSeleccionado.getMonth(),fechaDiaSeleccionado.getDate(),Integer.parseInt(hourStart[0]),0,0,0);
        Timestamp timestampEnd = new Timestamp(fechaDiaSeleccionado.getYear(),fechaDiaSeleccionado.getMonth(),fechaDiaSeleccionado.getDate(),Integer.parseInt(hourEnd[0]),0,0,0);
        Date dateStart = new Date(timestampStart.getTime());
        Date dateEnd = new Date(timestampEnd.getTime());
        if (errors(hourStart,hourEnd,dateStart,dateEnd,dateHoy)){
            ScheduleEvent newEvent = new DefaultScheduleEvent("Horario Restringido", dateStart, dateEnd);
            this.eventModel.updateEvent(newEvent);
            try {
                serviciosBiblioteca.nuevaReserva(usuario, this.recursoactual.getId(), dateHoy, timestampStart, timestampEnd, false, "restringido", timestampHoy);
            } catch (PersistenceException e) {
                showErrors(e.getMessage());
            }
        }
    }

    /**
     * Metodo para mostrar errores en pantalla
     * @param message mensaje de error
     */
    private void addMessage(FacesMessage message) {
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    /**
     * Metodo para cambiar error
     * @param error error mostrado en pantalla
     */
    public void showErrors(String error) {
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }

    /**
     * Metodo para mover el Evento
     * @param event evento
     */
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
        addMessage(message);
    }

    /**
     * Metodo para cambiar tamaño del evento
     * @param event evento
     */
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public ScheduleEvent getEventAux() {
        return eventAux;
    }

    public int getEventId() {
        return eventId;
    }

    public Timestamp getNewFechaInicio() {
        return newFechaInicio;
    }

    public Timestamp getNewFechaFin() {
        return newFechaFin;
    }

    public Timestamp getFechainicio() {
        return fechainicio;
    }

    public Timestamp getFechafin() {
        return fechafin;
    }

    public Horario getHorarioactual() {
        return horarioactual;
    }

    public Reserva getReservaactual() {
        return reservaactual;
    }

    public Recurso getRecursoactual() {
        return recursoactual;
    }

    public java.util.Date getFechaDiaSeleccionado() {
        return fechaDiaSeleccionado;
    }

    public String getSelectedHourStart() {
        return selectedHourStart;
    }

    public String getSelectedHourEnd() {
        return selectedHourEnd;
    }

    public void setSelectedHourStart(String selectedHourStart) {
        this.selectedHourStart = selectedHourStart;
    }

    public void setSelectedHourEnd(String selectedHourEnd) {
        this.selectedHourEnd = selectedHourEnd;
    }


    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void setEventAux(ScheduleEvent eventAux) {
        this.eventAux = eventAux;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setNewFechaInicio(Timestamp newFechaInicio) {
        this.newFechaInicio = newFechaInicio;
    }

    public void setNewFechaFin(Timestamp newFechaFin) {
        this.newFechaFin = newFechaFin;
    }

    public void setFechainicio(Timestamp fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Timestamp fechafin) {
        this.fechafin = fechafin;
    }

    public void setHorarioactual(Horario horarioactual) {
        this.horarioactual = horarioactual;
    }

    public void setReservaactual(Reserva reservaactual) {
        this.reservaactual = reservaactual;
    }

    public void setRecursoactual(Recurso recursoactual) {
        this.recursoactual = recursoactual;
    }

    public void setFechaDiaSeleccionado(java.util.Date fechaDiaSeleccionado) {
        this.fechaDiaSeleccionado = fechaDiaSeleccionado;
    }

}
