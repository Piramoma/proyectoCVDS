package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RecursoMapper {

    /**
     * Consultar los libros disponibles en la plataforma
     * @return lista de los libros disponibles en la plataforma
     */
    public List<Recurso> consultarLibros();

    /**
     * Consultar los Equipos disponibles en la plataforma
     * @return lista de los Equipos disponibles en la plataforma
     */
    public List<Recurso> consultarEquipos();

    /**
     * Consultar las Salas de Estudio disponibles en la plataforma
     * @return lista de las Salas de Estudio disponibles en la plataforma
     */
    public List<Recurso> consultarSalasEstudio();

    /**
     * Agregar recurso a la plataforma
     * @param r recurso
     */
    public void insertarRecurso(@Param ("r") Recurso r);

}
