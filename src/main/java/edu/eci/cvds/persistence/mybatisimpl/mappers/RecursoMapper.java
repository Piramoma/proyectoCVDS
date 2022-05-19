package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;

import java.sql.SQLException;
import java.util.List;

import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import org.apache.ibatis.annotations.Param;
import org.postgresql.util.PSQLException;

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
                             @Param("descripcion")String descripcion) throws PersistenceException;

    /**
     * Metodo para consultar Recurso especifico
     * @param idrecurso id recurso
     * @return Recurso
     * @throws PersistenceException excepciones
     */
    public Recurso consultarRecurso(@Param("idrecurso") int idrecurso) throws PersistenceException;

    /**
     * Metodo para cambiar estado de recurso
     * @param newEstado nuevo estado
     * @param idRecurso id recurso
     * @throws PersistenceException excepciones
     */
    public void cambiarEstadoRecurso(@Param("newEstado") String newEstado, @Param("idRecurso") int idRecurso) throws PersistenceException;

    /**
     * Metodo para cosultar libros
     * @return Lista de libros
     * @throws PersistenceException excepciones
     */
    public List<Recurso> consultarTodoLibros() throws PersistenceException;

    /**
     * Metodo para cosultar Equipos
     * @return Lista de Equipos
     * @throws PersistenceException excepciones
     */
    public List<Recurso> consultarTodoEquipos() throws PersistenceException;

    /**
     * Metodo para cosultar Salas
     * @return Lista de Salas
     * @throws PersistenceException excepciones
     */
    public List<Recurso> consultarTodoSalasEstudio() throws PersistenceException;
}
