package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Recurso;

import java.util.List;

public interface RecursoMapper {

    public List<Recurso> consultarLibros();
}
