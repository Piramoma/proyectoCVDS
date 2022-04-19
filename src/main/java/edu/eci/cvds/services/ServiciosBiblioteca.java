package edu.eci.cvds.services;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.List;

public interface ServiciosBiblioteca {

    public List<Recurso> consultarLibros() throws PersistenceException;
}
