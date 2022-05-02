package edu.eci.cvds.persistence.mybatisimpl;
import com.google.inject.Inject;
import edu.eci.cvds.entities.Horario;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.HorarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.HorarioMapper;

import java.util.List;

public class MyBATISHorarioDAO implements HorarioDAO {

    @Inject
    private HorarioMapper horarioMapper;

    @Override
    public List<Horario> consultarHorarios() {
        return horarioMapper.consultarHorarios();
    }

}

