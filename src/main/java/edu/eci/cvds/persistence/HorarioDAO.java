package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.persistence.exception.PersistenceException;

import java.util.List;

public interface HorarioDAO {

    public List<Horario> consultarHorarios() throws PersistenceException;

    public List<Horario> consultaHorariosRecurso(int idrecurso) throws PersistenceException;

    public Horario consultarHorario(int idrecurso, int idhorario) throws PersistenceException;

}
