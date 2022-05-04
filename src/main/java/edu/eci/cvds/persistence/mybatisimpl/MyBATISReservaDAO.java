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
    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id) {
        return reservaMapper.consultarPorUsuarioMuchaInfo(idUsuario, id);
    }

    @Override
    public List<Reserva> consultarReservasPasadas(String idUsuario) {
        return reservaMapper.consultarReservasPasadas(idUsuario);
    }

    @Override
    public List<Reserva> consultarReservasCanceladas(String idUsuario) {
        return reservaMapper.consultarReservasCanceladas(idUsuario);
    }

    @Override
    public List<Reserva> listarReservasRecurso(int idrecurso) {
        return reservaMapper.listarReservasRecurso(idrecurso);
    }

    @Override
    public Reserva consultarReserva(int idrecurso, int idreserva) {
        return reservaMapper.consultarReserva(idrecurso,idreserva);
    }

}
