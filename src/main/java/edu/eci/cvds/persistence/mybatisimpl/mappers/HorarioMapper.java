package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Usuario;

import java.util.List;

public interface HorarioMapper {

    /**
     * Consultar Horarios
     * @return lista de horarios
     */
    public List<Horario> consultarHorarios();

}
