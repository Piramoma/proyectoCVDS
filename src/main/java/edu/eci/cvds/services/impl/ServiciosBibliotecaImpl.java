package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBiblioteca;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ServiciosBibliotecaImpl implements ServiciosBiblioteca {

    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private ReservaDAO reservaDAO;
    @Inject
    private UsuarioDAO usuarioDAO;

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
    public void insertarRecurso(Recurso recurso) {
        recursoDAO.save(recurso);
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

}
