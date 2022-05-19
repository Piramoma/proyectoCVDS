package edu.eci.cvds.tests;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecursosTest {

    ServiciosBiblioteca serviciosBiblioteca;

    public RecursosTest(){
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }

    @Before
    public void setUp(){
    }

    @Test
    public void deberiaConsultarSoloLibros(){
        List<Recurso> recursosLibros = serviciosBiblioteca.consultarLibros();
        for(Recurso libro:recursosLibros){
            Assert.assertEquals("libro", libro.getTipo());
            Assert.assertEquals("disponible", libro.getEstado());
        }
    }

    @Test
    public void deberiaConsultarSoloSalas(){
        List<Recurso> recursosSalas = serviciosBiblioteca.consultarSalasEstudio();
        for (Recurso sala:recursosSalas){
            Assert.assertEquals("sala", sala.getTipo());
            Assert.assertEquals("disponible", sala.getEstado());
        }
    }

    @Test
    public void deberiaConsultarSoloEquipos(){
        List<Recurso> recursosEquipos = serviciosBiblioteca.consultarEquipos();
        for (Recurso equipo:recursosEquipos){
            Assert.assertEquals("equipo",equipo.getTipo());
            Assert.assertEquals("disponible", equipo.getEstado());
        }
    }
    
    @Test
    public void deberiaConsultarLibrosAdmin(){
        List<Recurso> recursosLibros = null;
        try {
            recursosLibros = serviciosBiblioteca.consultarTodoLibros();
            for (Recurso libro:recursosLibros){
                Assert.assertEquals("libro",libro.getTipo());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se logro consultar todos los libros");
        }
    }

    @Test
    public void deberiaConsultarEquiposAdmin(){
        List<Recurso> recursosEquipo = null;
        try {
            recursosEquipo = serviciosBiblioteca.consultarTodoEquipos();
            for (Recurso equipo:recursosEquipo){
                Assert.assertEquals("equipo",equipo.getTipo());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se logro consultar todos los libros");
        }
    }

    @Test
    public void deberiaConsultarSalasAdmin(){
        List<Recurso> recursosSalas = null;
        try {
            recursosSalas = serviciosBiblioteca.consultarTodoSalasEstudio();
            for (Recurso salas:recursosSalas){
                Assert.assertEquals("sala",salas.getTipo());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se logro consultar todos las salas");
        }
    }

    @Test
    public void deberiaConsultarSoloUnRecurso(){
        Recurso recurso = null;
        try {
            recurso = serviciosBiblioteca.consultarRecurso(9);
            Assert.assertEquals(9,recurso.getId());
            Assert.assertEquals(201, recurso.getIdInterno());
        } catch (PersistenceException e) {
            Assert.fail("No se logro consultar todos las salas");
        }
    }

    @Test
    public void deberiaCambiarEstadoDeRecurso(){
        try {
            serviciosBiblioteca.cambiarEstadoRecurso("Test",63);
            Assert.assertEquals("Test",serviciosBiblioteca.consultarRecurso(63).getEstado());
        } catch (PersistenceException e) {
            Assert.fail("No se logra cambiar el estado de un recurso");
        }
    }

    @Test
    public void deberiaAgegarRecurso(){
        try {
            serviciosBiblioteca.nuevoRecurso(1000,"Tests","Tests","Tests","Tests",0,"Solo para tests");
            Assert.assertEquals(1000,serviciosBiblioteca.consultarRecurso(64).getIdInterno());
        } catch (PersistenceException e) {
            Assert.assertEquals(PersistenceException.idInternoRepetido,e.getMessage());
        }
    }
}
