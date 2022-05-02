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
    public void save(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion) {
        recursoMapper.nuevoRecurso(idInterno,estado,nombre,ubicacion,tipo,capacidad,descripcion);
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

    @Override
    public void nuevoRecurso(int idInterno, String estado, String nombre, String ubicacion, String tipo, int capacidad, String descripcion) {
        recursoMapper.nuevoRecurso(idInterno,estado,nombre,ubicacion,tipo,capacidad, descripcion);
    }


}
