package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.List;

public interface ServiciosBiblioteca {

    public abstract List<Recurso> consultarLibros() ;

    public abstract List<Recurso> consultarEquipos() ;

    public abstract List<Recurso> consultarSalasEstudio() ;

    public void insertarRecurso(Recurso recurso);
    
}
