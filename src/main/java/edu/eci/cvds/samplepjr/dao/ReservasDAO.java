package edu.eci.cvds.samplepjr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Reservas;

public interface ReservasDAO {

    public void save(Reservas reserva) throws PersistenceException;

    public Reservas load(int idReserva) throws PersistenceException;

    public List<Reservas> reservasRecurso(int idRecurso) throws PersistenceException;

}
