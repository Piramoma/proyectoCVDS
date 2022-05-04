package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HorarioMapper {

    /**
     * Consultar Horarios
     * @return lista de horarios
     */
    public List<Horario> consultarHorarios();

    public List<Horario> consultaHorariosRecurso(@Param("idrecurso") int idrecurso);

    public Horario consultarHorario(@Param("idrecurso") int idrecurso, @Param("idhorario") int idhorario);
}
