package edu.eci.cvds.persistence;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;

import java.util.List;

public interface RecursoDAO {

    public void save(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion);

    public Recurso load(int id);

    public List<Recurso> consultarLibros();

    public List<Recurso> consultarEquipos();

    public List<Recurso> consultarSalasEstudio();

    public List<Recurso> consultarRecurso(int idrecurso);

    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion);
}
