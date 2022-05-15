package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservaMapper {

    public List<Reserva> consultarPorUsuarioPocaInfo(@Param("idUsuario") String idUsuario) throws PersistenceException;

    public List<Reserva> consultarPorUsuarioMuchaInfo(@Param("idUsuario") String idUsuario, @Param("idreserva") int id) throws PersistenceException;

    public List<Reserva> consultarReservasPasadas(@Param("idUsuario") String idUsuario) throws PersistenceException;

    public List<Reserva> consultarReservasCanceladas(@Param("idUsuario") String idUsuario) throws PersistenceException;

    public List<Reserva> listarReservasRecurso(@Param ("idrecurso") int idrecurso) throws PersistenceException;

    public Reserva consultarReserva(@Param ("idrecurso") int idrecurso, @Param ("idreserva") int idreserva) throws PersistenceException;

    public void nuevaReserva(@Param ("idusuario") String idusuario,
                             @Param ("idrecurso") int idrecurso,
                             @Param ("fechasolicitud") Date fechasolicitud,
                             @Param ("fechainicioreserva") Timestamp fechainicioreserva,
                             @Param ("fechafinreserva") Timestamp fechafinreserva,
                             @Param ("recurrente") boolean recurrente,
                             @Param ("estado") String estado,
                             @Param ("diaactual") Timestamp diaactual) throws PersistenceException;
}
