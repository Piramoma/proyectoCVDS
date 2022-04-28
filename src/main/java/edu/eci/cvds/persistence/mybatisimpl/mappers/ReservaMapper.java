package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Reserva;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReservaMapper {

    public List<Reserva> consultarPorUsuarioPocaInfo(@Param("idUsuario") String idUsuario);

}
