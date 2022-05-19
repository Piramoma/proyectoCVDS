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

    /**
     * Metodo Horarios de un recurso
     * @param idrecurso recurso
     * @return Lista de horarios
     * @throws PersistenceException excepciones
     */
    public List<Horario> consultaHorariosRecurso(@Param("idrecurso") int idrecurso) throws PersistenceException;

    /**
     * Metodo para consultar horario especifico
     * @param idrecurso recurso
     * @param idhorario horario
     * @return Horario
     * @throws PersistenceException excepciones
     */
    public Horario consultarHorario(@Param("idrecurso") int idrecurso, @Param("idhorario") int idhorario) throws PersistenceException;
}
