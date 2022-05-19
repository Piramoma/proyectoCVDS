package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;

import java.util.List;

public class MyBATISHorarioDAO implements HorarioDAO {

    @Inject
    private HorarioMapper horarioMapper;

    @Override
    public List<Horario> consultarHorarios() throws PersistenceException {
        try {
            return horarioMapper.consultarHorarios();
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarLosHorarios);
        }
    }

    @Override
    public List<Horario> consultaHorariosRecurso(int idrecurso) throws PersistenceException {
        try {
            return horarioMapper.consultaHorariosRecurso(idrecurso);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.errorAlconsultarHorariosDeUnRecurso);
        }
    }

    @Override
    public Horario consultarHorario(int idrecurso, int idhorario) throws PersistenceException {
        try {
            return horarioMapper.consultarHorario(idrecurso, idhorario);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.errorAlconsultarHorariosDeUnRecurso);
        }
    }

}

