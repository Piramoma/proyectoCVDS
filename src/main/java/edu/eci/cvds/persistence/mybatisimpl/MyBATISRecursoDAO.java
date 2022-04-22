package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;

import java.util.List;

public class MyBATISRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;

    @Override
    public void save(Recurso recurso) {
        recursoMapper.insertarRecurso(recurso);
    }

    @Override
    public Recurso load(int id) {
        return null;
    }

    @Override
    public List<Recurso> consultarLibros() {
        return recursoMapper.consultarLibros();
    }

    @Override
    public List<Recurso> consultarEquipos() {
        return recursoMapper.consultarEquipos();
    }

    @Override
    public List<Recurso> consultarSalasEstudio() {
        return recursoMapper.consultarSalasEstudio();
    }

}
