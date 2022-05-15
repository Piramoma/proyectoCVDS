package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Usuario;
import com.google.inject.Inject;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

import java.util.List;

public class MyBATISUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public List<Usuario> consultarUsuariosConReservas() throws PersistenceException{
        try{
            return usuarioMapper.consultarUsuariosConReservas();
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarUsuariosConReservas);
        }

    }

    @Override
    public Usuario consultarNombreUsuario(String idUsuario) throws PersistenceException {
        try{
            return usuarioMapper.consultarNombreUsuario(idUsuario);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSeEncuentraAlUsuario);
        }

    }
}
