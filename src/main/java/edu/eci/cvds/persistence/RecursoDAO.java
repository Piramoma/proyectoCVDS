package edu.eci.cvds.persistence;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;

import java.util.List;

public interface RecursoDAO {


    public void save(Recurso recurso);

    public Recurso load(int id);

    public List<Recurso> consultarLibros();
}
