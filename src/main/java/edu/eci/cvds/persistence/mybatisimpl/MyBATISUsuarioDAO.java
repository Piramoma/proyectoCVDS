package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.entities.Usuario;
import com.google.inject.Inject;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;

import java.util.List;

public class MyBATISUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public List<Usuario> consultarUsuariosConReservas() {
        return usuarioMapper.consultarUsuariosConReservas();
    }
}
