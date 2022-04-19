package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.util.List;

public class ServiciosBibliotecaImpl implements ServiciosBiblioteca {

    @Inject
    private RecursoDAO recursoDAO;

    @Override
    public List<Recurso> consultarLibros() throws PersistenceException {
        return recursoDAO.consultarLibros();
    }
}
