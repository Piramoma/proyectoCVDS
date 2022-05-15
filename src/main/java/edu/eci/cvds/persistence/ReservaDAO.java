package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservaDAO {

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) throws PersistenceException;

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id) throws PersistenceException;

    public List<Reserva> consultarReservasPasadas(String idUsuario) throws PersistenceException;

    public List<Reserva> consultarReservasCanceladas(String idUsuario) throws PersistenceException;

    public List<Reserva> listarReservasRecurso(int idrecurso) throws PersistenceException;

    public Reserva consultarReserva(int idrecurso, int idreserva) throws PersistenceException;

    public void nuevaReserva(String idusuario, int idrecurso, Date fechasolicitud, Timestamp fechainicioreserva, Timestamp fechafinreserva, boolean recurrente, String estado, Timestamp diaactual) throws PersistenceException;

}
