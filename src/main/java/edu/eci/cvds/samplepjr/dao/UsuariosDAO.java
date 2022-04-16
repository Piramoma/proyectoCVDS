package edu.eci.cvds.samplepjr.dao;

import edu.eci.cvds.samples.entities.Usuarios;

public interface UsuariosDAO {

    public void save(Usuarios usuario) throws PersistenceException;

    public Usuarios load(int idUsuario) throws PersistenceException;

}
