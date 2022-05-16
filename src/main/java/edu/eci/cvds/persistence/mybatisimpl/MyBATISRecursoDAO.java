package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.RecursoMapper;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.List;

public class MyBATISRecursoDAO implements RecursoDAO {

    @Inject
    private RecursoMapper recursoMapper;

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
    public void nuevoRecurso(int idInterno,
                             String estado,
                             String nombre,
                             String ubicacion,
                             String tipo,
                             int capacidad,
                             String descripcion) throws PersistenceException {
        try{
            recursoMapper.nuevoRecurso(idInterno,estado,nombre,ubicacion,tipo,capacidad, descripcion);
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            if (e.getLocalizedMessage().contains("uk_recursos_idinterno")) { throw new PersistenceException(PersistenceException.idInternoRepetido); }
            throw new PersistenceException(PersistenceException.errorAlRegistrarNuevoRecurso);
        }
    }

    @Override
    public void cambiarEstadoRecurso(String newEstado, int idRecurso) throws PersistenceException {
        try{
            recursoMapper.cambiarEstadoRecurso(newEstado,idRecurso);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePudoActualizarEstadoRecurso);
        }
    }

    @Override
    public Recurso consultarRecurso(int idrecurso) throws PersistenceException{
        try {
            return recursoMapper.consultarRecurso(idrecurso);
        }catch (Exception e){
            e.printStackTrace();
            throw new PersistenceException(PersistenceException.noSePuedeConsultarRecursosPorId);
        }
    }
}
