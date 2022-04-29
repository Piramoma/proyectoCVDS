package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.persistence.ReservaDAO;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;

import java.util.List;

public class MyBATISReservaDAO implements ReservaDAO {

    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) {
        return reservaMapper.consultarPorUsuarioPocaInfo(idUsuario);
    }

    @Override
    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario) {
        return reservaMapper.consultarPorUsuarioMuchaInfo(idUsuario);
    }
}
