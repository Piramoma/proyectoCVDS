package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;

import java.util.List;

public interface UsuarioDAO {

    public List<Usuario> consultarUsuariosConReservas() throws PersistenceException;

}
