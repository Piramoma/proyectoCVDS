package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.exception.PersistenceException;

import java.util.List;

public interface RecursoDAO {

    public Recurso load(int id);

    public List<Recurso> consultarLibros();

    public List<Recurso> consultarEquipos();

    public List<Recurso> consultarSalasEstudio();

    public Recurso consultarRecurso(int idrecurso) throws PersistenceException;

    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion) throws PersistenceException;

    public void cambiarEstadoRecurso(String newEstado, int idRecurso) throws PersistenceException;

    public List<Recurso> consultarTodoLibros() throws PersistenceException;

    public List<Recurso> consultarTodoEquipos() throws PersistenceException;

    public List<Recurso> consultarTodoSalasEstudio() throws PersistenceException;
}
