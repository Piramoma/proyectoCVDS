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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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

    private List<String> hours;

    private String selectedHourStart;

    private String selectedHourEnd;

    private String tipoReserva;

    /**
     * Metodo para inicializar el horario de los recursos
     * @param idRecurso id del Recurso elegido
     */
    public void inicializarHorario(int idRecurso) {
        this.idRecurso = idRecurso;
        eventModel = new DefaultScheduleModel();
        loadEvents();
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
    public void addEvent(String usuario) {
        if (errors()){
            ScheduleEvent newEvent = new DefaultScheduleEvent();
            newEvent = new DefaultScheduleEvent("Reserva Activa", event.getStartDate(), event.getEndDate());
            this.eventModel.updateEvent(event);
            Timestamp timeStampInicio = new Timestamp(event.getStartDate().getTime());
            Timestamp timeStampFin = new Timestamp(event.getEndDate().getTime());
            LocalDate localDateHoy = LocalDate.now();
            java.sql.Date dateHoy = Date.valueOf(localDateHoy);
            Timestamp timestampHoy = new Timestamp(dateHoy.getTime());
            try {
                serviciosBiblioteca.nuevaReserva(usuario, this.recursoactual.getId(), dateHoy, timeStampInicio, timeStampFin, false, "activa", timestampHoy);
            } catch (PersistenceException e) {
                showErrors(e.getMessage());
            }
        }
    }

    /**
     * Metodo para que al admin añada un evento
     * @param usuario Admin
     */
    public void addEventAdmin(String usuario) {
        if (errors()){
            ScheduleEvent newEvent = new DefaultScheduleEvent();
            newEvent = new DefaultScheduleEvent("Restringido", event.getStartDate(), event.getEndDate());
            this.eventModel.updateEvent(event);
            Timestamp timeStampInicio = new Timestamp(event.getStartDate().getTime());
            Timestamp timeStampFin = new Timestamp(event.getEndDate().getTime());
            LocalDate localDateHoy = LocalDate.now();
            java.sql.Date dateHoy = Date.valueOf(localDateHoy);
            Timestamp timestampHoy = new Timestamp(dateHoy.getTime());
            try {
                serviciosBiblioteca.nuevaReserva(usuario, this.recursoactual.getId(), dateHoy, timeStampInicio, timeStampFin, false, "restringido", timestampHoy);
            } catch (PersistenceException e) {
                showErrors(e.getMessage());
            }
        }
    }

    /**
     * Metodo para verificar errores cuando se va añadir un evento
     * @return
     */
    private boolean errors() {
        boolean isError = true;
        if (Objects.equals(event.getStartDate(),null)) {
            showErrors("El campo de Fecha Inicial es Nulo");
            isError=false;
        }
        else if (Objects.equals(event.getEndDate(),null))  {
            showErrors("El campo de Fecha Final es Nulo");
            isError=false;
        }
        else if (event.getStartDate().getTime() > event.getEndDate().getTime())
        { showErrors("La Fecha Final Debe ser mayor a la Fecha Inicial");
            isError=false;
        }
        else if ((event.getEndDate().getHours() - event.getStartDate().getHours()) > 2) {
            showErrors("EL Tiempo maximo de la reserva es 2 Horas.");
            isError=false;
        }
        return isError;
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

    public List<String> getHours() {
        return hours;
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

    public String getTipoReserva() {
        return tipoReserva;
    }
}
