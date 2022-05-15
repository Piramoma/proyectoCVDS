package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HorarioMapper {

    /**
     * Consultar Horarios
     * @return lista de horarios
     */
    public List<Horario> consultarHorarios() throws PersistenceException;

    public List<Horario> consultaHorariosRecurso(@Param("idrecurso") int idrecurso) throws PersistenceException;

    public Horario consultarHorario(@Param("idrecurso") int idrecurso, @Param("idhorario") int idhorario) throws PersistenceException;
}
