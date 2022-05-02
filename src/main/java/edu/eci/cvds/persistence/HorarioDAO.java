package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Horario;

import java.util.List;

public interface HorarioDAO {

    public List<Horario> consultarHorarios();

}
