package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;

import java.util.List;

import edu.eci.cvds.entities.Reserva;
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
     * Agregar a la base de datos
     * @param idInterno idInterno
     * @param estado estado
     * @param nombre nombre
     * @param ubicacion ubicacion
     * @param tipo tipo
     * @param capacidad capacidad
     */
    public void nuevoRecurso(@Param("idInterno") int idInterno,
                             @Param("estado") String  estado,
                             @Param("nombre") String nombre,
                             @Param("ubicacion") String ubicacion,
                             @Param("tipo") String tipo,
                             @Param("capacidad")int capacidad,
                             @Param("descripcion")String descripcion);

    public Recurso consultarRecurso(@Param("idrecurso") int idrecurso);
}
