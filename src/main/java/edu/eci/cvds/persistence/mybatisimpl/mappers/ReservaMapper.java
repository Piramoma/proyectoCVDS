package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservaMapper {

    /**
     * Consultar Usuarios con poca informacion
     * @param idUsuario usuario
     * @return Lista de reservas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarPorUsuarioPocaInfo(@Param("idUsuario") String idUsuario) throws PersistenceException;

    /**
     * Consultar Usuarios con mucha informacion
     * @param idUsuario usuario
     * @return Lista de reservas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarPorUsuarioMuchaInfo(@Param("idUsuario") String idUsuario, @Param("idreserva") int id) throws PersistenceException;

    /**
     * Consultar reservas pasadas de un usuario
     * @param idUsuario usuario
     * @return Lista de reservas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarReservasPasadas(@Param("idUsuario") String idUsuario) throws PersistenceException;

    /**
     * Consultar reservas canceladas de un usuario
     * @param idUsuario usuario
     * @return Lista de reservas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarReservasCanceladas(@Param("idUsuario") String idUsuario) throws PersistenceException;

    /**
     * Consultar reservas de un recurso
     * @param idrecurso recurso
     * @return Lista de reservas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> listarReservasRecurso(@Param ("idrecurso") int idrecurso) throws PersistenceException;

    /**
     * Consultar reservas especifica
     * @param idrecurso recurso
     * @param idreserva reserva
     * @return Reserva especifica
     * @throws PersistenceException excepciones
     */
    public Reserva consultarReserva(@Param ("idrecurso") int idrecurso, @Param ("idreserva") int idreserva) throws PersistenceException;

    /**
     * Metodo para añadir una reserva
     * @param idusuario idusuario
     * @param idrecurso idrecurso
     * @param fechasolicitud fecha solicitud
     * @param fechainicioreserva fecha inicio de reserva
     * @param fechafinreserva fecha fin de reserva
     * @param recurrente fecha recurrente
     * @param estado estado
     * @param diaactual dia actual
     * @throws PersistenceException excepciones
     */
    public void nuevaReserva(@Param ("idusuario") String idusuario,
                             @Param ("idrecurso") int idrecurso,
                             @Param ("fechasolicitud") Date fechasolicitud,
                             @Param ("fechainicioreserva") Timestamp fechainicioreserva,
                             @Param ("fechafinreserva") Timestamp fechafinreserva,
                             @Param ("recurrente") boolean recurrente,
                             @Param ("estado") String estado,
                             @Param ("diaactual") Timestamp diaactual) throws PersistenceException;

    /**
     * Metodo para cancelar reserva
     * @param idReserva reserva
     * @throws PersistenceException excepciones
     */
    public void cancelarReserva(@Param("idReserva") int idReserva) throws PersistenceException;

    /**
     * Metodo para consultar recursos mas usados
     * @throws PersistenceException excepciones
     */
    public List<Reserva> recursosMasUsados() throws PersistenceException;

    /**
     * Metodo para consultar recursos menos usados
     * @throws PersistenceException excepciones
     */
    public List<Reserva> recursosMenosUsados() throws PersistenceException;

    /**
     * Metodo para consultar recursos por carrera
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarReservasPorCarrera() throws PersistenceException;

    /**
     * Metodo para consultar recursos por usuario
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarReservasPorUsuario() throws PersistenceException;

    /**
     * Metodo para consultar horarios con mayor ocupacion
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarHorariosMayorOcupacion() throws PersistenceException;

    /**
     * Metodo para consultar horarios con menor ocupacion
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarHorariosMenorOcupacion() throws PersistenceException;

    /**
     * Metodo para consultar reservas canceladas
     * @throws PersistenceException excepciones
     */
    public List<Reserva> consultarReservasCanceladasGrafico() throws PersistenceException;

}