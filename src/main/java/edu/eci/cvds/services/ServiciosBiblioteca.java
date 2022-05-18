package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.postgresql.util.PSQLException;


import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;

public interface ServiciosBiblioteca {

    public abstract List<Recurso> consultarLibros() ;

    public abstract List<Recurso> consultarEquipos() ;

    public abstract List<Recurso> consultarSalasEstudio() ;

    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion) throws PersistenceException;

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) throws PersistenceException;

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id) throws PersistenceException;

    public abstract List<Usuario> consultarUsuariosConReservas() throws PersistenceException;

    public abstract List<Horario> consultarHorarios() throws PersistenceException;

    public List<Reserva> consultarReservasPasadas(String idUsuario) throws PersistenceException;

    public List<Reserva> consultarReservasCanceladas(String idUsuario) throws PersistenceException;

    public List<Reserva> listarReservasRecurso(int idrecurso) throws PersistenceException;

    public Recurso consultarRecurso(int idrecurso) throws PersistenceException;

    public List<Horario> consultaHorariosRecurso(int idrecurso) throws PersistenceException;

    public Horario consultarHorario(int idrecurso, int idhorario) throws PersistenceException;

    public Reserva consultarReserva(int idrecurso, int idreserva) throws PersistenceException;

    public void nuevaReserva(String idusuario, int idrecurso, Date fechasolicitud, Timestamp fechainicioreserva, Timestamp fechafinreserva, boolean recurrente, String estado, Timestamp diaactual) throws PersistenceException;

    public Usuario consultarNombreUsuario(String idUsuario) throws PersistenceException;

    //public List<Reserva> reservasMasUsadas() throws PersistenceException;

    //public List<Reserva> reservasMenosUsadas() throws PersistenceException;

    //public List<Reserva> horariosMayorOcupacion() throws PersistenceException;

    //public List<Reserva> horariosMenorOcupacion() throws PersistenceException;

    public void cambiarEstadoRecurso(String newEstado, int idRecurso) throws PersistenceException;

    public List<Recurso> consultarTodoLibros() throws PersistenceException;

    public List<Recurso> consultarTodoEquipos() throws PersistenceException;

    public List<Recurso> consultarTodoSalasEstudio() throws PersistenceException;

}
