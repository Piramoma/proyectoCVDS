package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioMapper {

    /**
     * Consultar Usuarios que tienen reservas activas
     * @return lista de usuarios con reservas activas
     */
    public List<Usuario> consultarUsuariosConReservas() throws PersistenceException;

    /**
     * Consultar Nombre de usuario
     * @param idUsuario nombre de usuario
     * @return Nombre de usuario
     * @throws PersistenceException excepciones
     */
    public Usuario consultarNombreUsuario(@Param("idUsuario") String idUsuario) throws PersistenceException;

}
