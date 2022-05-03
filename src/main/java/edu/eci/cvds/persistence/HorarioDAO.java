package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Recurso;

import java.util.List;

public interface HorarioDAO {

    public List<Horario> consultarHorarios();

    public List<Horario> consultaHorariosRecurso(int idrecurso);


}
