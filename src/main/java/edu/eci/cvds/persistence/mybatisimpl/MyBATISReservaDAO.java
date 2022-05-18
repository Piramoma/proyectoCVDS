package edu.eci.cvds.persistence.mybatisimpl;

import edu.eci.cvds.persistence.ReservaDAO;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.ReservaDAO;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ReservaMapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MyBATISReservaDAO implements ReservaDAO {

    @Inject
    private ReservaMapper reservaMapper;

    @Override
    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario) throws PersistenceException {
        try {
            return reservaMapper.consultarPorUsuarioPocaInfo(idUsuario);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarPocaInfoPorUsuario);
        }
    }

    @Override
    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario, int id)throws PersistenceException{
        try {
            return reservaMapper.consultarPorUsuarioMuchaInfo(idUsuario, id);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarMuchaInfoPorUsuario);
        }
    }

    @Override
    public List<Reserva> consultarReservasPasadas(String idUsuario) throws PersistenceException {
        try {
            return reservaMapper.consultarReservasPasadas(idUsuario);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeconsultarHistorialDeReservas);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladas(String idUsuario) throws PersistenceException {
        try {
            return reservaMapper.consultarReservasCanceladas(idUsuario);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarReservasCanceladas);
        }
    }

    @Override
    public List<Reserva> listarReservasRecurso(int idrecurso) throws PersistenceException {
        try {
            return reservaMapper.listarReservasRecurso(idrecurso);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public Reserva consultarReserva(int idrecurso, int idreserva) throws PersistenceException {
        try {
            return reservaMapper.consultarReserva(idrecurso,idreserva);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.errorAlConsultarUnaReserva);
        }
    }

    @Override
    public void nuevaReserva(String idusuario,
                             int idrecurso,
                             Date fechasolicitud,
                             Timestamp fechainicioreserva,
                             Timestamp fechafinreserva,
                             boolean recurrente,
                             String estado,
                             Timestamp diaactual) throws PersistenceException {
        try {
            reservaMapper.nuevaReserva(idusuario,idrecurso,fechasolicitud,fechainicioreserva,fechafinreserva,recurrente,estado,diaactual);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.errorAlRegistrarNuevaReserva);
        }
    }

    @Override
    public void cancelarReserva(int idReserva) throws PersistenceException {
        try{
            reservaMapper.cancelarReserva(idReserva);
        }catch (Exception e){
            throw new PersistenceException(PersistenceException.noSeEncuentraReserva);
        }
    }

    @Override
    public List<Reserva> recursosMasUsados() throws PersistenceException {
        try {
            return reservaMapper.recursosMasUsados();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public List<Reserva> recursosMenosUsados() throws PersistenceException {
        try {
            return reservaMapper.recursosMenosUsados();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public List<Reserva> consultarReservasPorCarrera() throws PersistenceException {
        try {
            return reservaMapper.consultarReservasPorCarrera();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public List<Reserva> consultarReservasPorUsuario() throws PersistenceException {
        try {
            return reservaMapper.consultarReservasPorUsuario();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public List<Reserva> consultarHorariosMayorOcupacion() throws PersistenceException {
        try {
            return reservaMapper.consultarHorariosMayorOcupacion();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }


    @Override
    public List<Reserva> consultarHorariosMenorOcupacion() throws PersistenceException {
        try {
            return reservaMapper.consultarHorariosMenorOcupacion();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }

    @Override
    public List<Reserva> consultarReservasCanceladasGrafico() throws PersistenceException {
        try {
            return reservaMapper.consultarReservasCanceladasGrafico();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLasReservasDeUnRecurso);
        }
    }


}
