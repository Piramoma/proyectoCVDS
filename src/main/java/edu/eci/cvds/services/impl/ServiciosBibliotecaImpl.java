package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBiblioteca;
import org.postgresql.util.PSQLException;

import javax.ejb.Singleton;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Singleton
public class ServiciosBibliotecaImpl implements ServiciosBiblioteca {

    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private ReservaDAO reservaDAO;
    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private HorarioDAO horarioDAO;

    @Override
    public List<Recurso> consultarLibros() {
        return recursoDAO.consultarLibros();
    }

    @Override
    public List<Recurso> consultarEquipos() {
        return recursoDAO.consultarEquipos();
    }

    @Override
    public List<Recurso> consultarSalasEstudio() {
        return recursoDAO.consultarSalasEstudio();
    }

    @Override
    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion) throws PSQLException {
        recursoDAO.nuevoRecurso(idInterno,estado,nombre,ubicacion,tipo,capacidad,descripcion);
    }

    @Override
    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) {
        return reservaDAO.consultarPorUsuarioPocaInfo(idUsuario);
    }

    @Override
    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id) {
        return reservaDAO.consultarPorUsuarioMuchaInfo(idUsuario, id);
    }

    @Override
    public List<Usuario> consultarUsuariosConReservas() {
        return usuarioDAO.consultarUsuariosConReservas();
    }

    @Override
    public List<Horario> consultarHorarios() {
        return horarioDAO.consultarHorarios();
    }

    @Override
    public List<Reserva> consultarReservasPasadas(String idUsuario) {
        return reservaDAO.consultarReservasPasadas(idUsuario);
    }

    @Override
    public List<Reserva> consultarReservasCanceladas(String idUsuario) {
        return reservaDAO.consultarReservasCanceladas(idUsuario);
    }

    @Override
    public List<Reserva> listarReservasRecurso(int idrecurso) {
        return reservaDAO.listarReservasRecurso(idrecurso);
    }

    @Override
    public Recurso consultarRecurso(int idrecurso) {
        return recursoDAO.consultarRecurso(idrecurso);
    }

    @Override
    public List<Horario> consultaHorariosRecurso(int idrecurso) {
        return horarioDAO.consultaHorariosRecurso(idrecurso);
    }

    @Override
    public Horario consultarHorario(int idrecurso, int idhorario) {
        return horarioDAO.consultarHorario(idrecurso, idhorario);
    }

    @Override
    public Reserva consultarReserva(int idrecurso, int idreserva) {
        return reservaDAO.consultarReserva(idrecurso, idreserva);
    }

    @Override
    public void nuevaReserva(String idusuario, int idrecurso, Date fechasolicitud, Timestamp fechainicioreserva, Timestamp fechafinreserva, boolean recurrente, String estado, Timestamp diaactual) {
        reservaDAO.nuevaReserva(idusuario,idrecurso,fechasolicitud,fechainicioreserva,fechafinreserva,recurrente,estado,diaactual);
    }

}
