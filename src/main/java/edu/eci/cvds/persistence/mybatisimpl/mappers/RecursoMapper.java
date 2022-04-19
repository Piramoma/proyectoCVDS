package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;

import java.util.List;

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

}
