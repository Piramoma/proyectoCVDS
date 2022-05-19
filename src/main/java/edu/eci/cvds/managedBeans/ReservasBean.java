package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;


@SuppressWarnings("deprecation")
@ManagedBean(name = "reservasBean")
@SessionScoped
public class ReservasBean extends BasePageBean {

    @Inject
    private ServiciosBiblioteca serviciosBiblioteca;


    /**
     * Metodo para consultar Usuarios con poca Informacin
     * @param idUsuario usuario
     * @return Lista de reservas
     */
    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarPorUsuarioPocaInfo(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para consultar Reservas Pasadas
     * @param idUsuario usuario
     * @return Lista de Reservas
     */
    public List<Reserva> consultarReservasPasadas(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarReservasPasadas(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para consultar Reservas Canceladas
     * @param idUsuario usuario
     * @return Lista de Reservas
     */
    public List<Reserva> consultarReservasCanceladas(String idUsuario) {
        try {
            return serviciosBiblioteca.consultarReservasCanceladas(idUsuario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para consultar Horarios
     * @param idrecurso recurso
     * @param idhorario horario
     * @return Horario
     */
    public Horario consultarHorario(int idrecurso, int idhorario) {
        try {
            return serviciosBiblioteca.consultarHorario(idrecurso, idhorario);
        } catch (PersistenceException e) {
            showErrors(e.getMessage());
        }
        return null;
    }

    /**
     * Metodo para cancelar Reserva
     * @param idRecurso recurso
     */
    public void cancelarReserva(int idRecurso){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/public/misReservas.xhtml");
            serviciosBiblioteca.cancelarReserva(idRecurso);
        }catch (PersistenceException | IOException e){
            showErrors(e.getMessage());
        }
    }

    /**
     * Metodo para mostrar errores en pantalla
     * @param error erroes
     */
    public void showErrors(String error) {
        FacesContext.getCurrentInstance().addMessage("Shiro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Intente de nuevo: ", error));
    }

    /**
     * Metodo para consultar Horarios con mucha ocupacin
     * @return Lista de reservas
     * @throws PersistenceException exepciones
     */
    public List<Reserva> consultarHorariosMayorOcupacion() throws PersistenceException {
        return serviciosBiblioteca.consultarHorariosMayorOcupacion();
    }

    /**
     * Metodo para consultar Horarios con poca ocupacin
     * @return Lista de reservas
     * @throws PersistenceException exepciones
     */
    public List<Reserva> consultarHorariosMenorOcupacion() throws PersistenceException {
        return serviciosBiblioteca.consultarHorariosMenorOcupacion();
    }

}
