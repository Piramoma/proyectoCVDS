package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioMapper {

    /**
     * Consultar Usuarios que tienen reservas activas
     * @return lista de usuarios con reservas activas
     */
    public List<Usuario> consultarUsuariosConReservas();

}
