package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservaDAO {

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario);

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id);

    public List<Reserva> consultarReservasPasadas(String idUsuario);

    public List<Reserva> consultarReservasCanceladas(String idUsuario);

    public List<Reserva> listarReservasRecurso(int idrecurso);

    public Reserva consultarReserva(int idrecurso, int idreserva);

    public void nuevaReserva(String idusuario, int idrecurso, Date fechasolicitud, Timestamp fechainicioreserva, Timestamp fechafinreserva, boolean recurrente, String estado, Timestamp diaactual);

}
