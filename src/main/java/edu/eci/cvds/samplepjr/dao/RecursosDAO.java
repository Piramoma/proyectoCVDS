package edu.eci.cvds.samplepjr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Recursos;

public interface RecursosDAO {
    
    public void save(Recursos recurso) throws PersistenceException;

    public Recursos load(int idRecurso) throws PersistenceException;

    public List<Recursos> consultarDisponibles() throws PersistenceException;

    public List<Recursos> consultarDisponiblePorTipo(String tipo) throws PersistenceException;

    public String getUbicacion(int idRecurso) throws PersistenceException;

    public int getCapacidad(int idRecurso) throws PersistenceException;

}
