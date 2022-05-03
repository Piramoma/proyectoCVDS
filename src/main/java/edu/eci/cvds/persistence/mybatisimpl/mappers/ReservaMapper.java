package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservaMapper {

    public List<Reserva> consultarPorUsuarioPocaInfo(@Param("idUsuario") String idUsuario);

    public List<Reserva> consultarPorUsuarioMuchaInfo(@Param("idUsuario") String idUsuario, @Param("idreserva") int id);

    public List<Reserva> consultarReservasPasadas(@Param("idUsuario") String idUsuario);

    public List<Reserva> consultarReservasCanceladas(@Param("idUsuario") String idUsuario);

    public List<Reserva> listarReservasRecurso(@Param ("idrecurso") int idrecurso);

}
