package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Reserva;

import java.util.List;

public interface ReservaDAO {

    public List<Reserva> consultarPorUsuarioPocaInfo(String idUsuario);

    public List<Reserva> consultarPorUsuarioMuchaInfo(String idUsuario);

}
