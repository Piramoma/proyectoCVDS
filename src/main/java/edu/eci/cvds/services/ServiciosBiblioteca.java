package edu.eci.cvds.services;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.List;

public interface ServiciosBiblioteca {

    public abstract List<Recurso> consultarLibros() ;

    public abstract List<Recurso> consultarEquipos() ;

    public abstract List<Recurso> consultarSalasEstudio() ;

    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion);

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario);

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id);

    public abstract List<Usuario> consultarUsuariosConReservas() ;

    public abstract List<Horario> consultarHorarios() ;

    public List<Reserva> consultarReservasPasadas(String idUsuario);

    public List<Reserva> consultarReservasCanceladas(String idUsuario);

    public List<Reserva> listarReservasRecurso(int idrecurso);

    public List<Recurso> consultarRecurso(int idrecurso);

    public List<Horario> consultaHorariosRecurso(int idrecurso);

}
