package edu.eci.cvds.samplepjr.dao;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Devoluciones;

public interface DevolucionesDAO {

    public void save(Devoluciones devolucion) throws PersistenceException;

    public Devoluciones load(int idRecurso) throws PersistenceException;

    public List<Devoluciones> consultarDevolucionesRecurso(int idRecurso) throws PersistenceException;

    public List<Devoluciones> consultarDevolucionesFecha(Date fechaDevolucion) throws PersistenceException;
    
}
