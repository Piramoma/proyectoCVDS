package edu.eci.cvds.tests;

import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        }
    }

    @Test
    public void deberiaConsultarSoloSalas(){
        List<Recurso> recursosSalas = serviciosBiblioteca.consultarSalasEstudio();
        for (Recurso sala:recursosSalas){
            Assert.assertEquals("sala", sala.getTipo());
        }
    }

    @Test
    public void deberiaConsultarSoloEquipos(){
        List<Recurso> recursosEquipos = serviciosBiblioteca.consultarEquipos();
        for (Recurso equipo:recursosEquipos){
            Assert.assertEquals("equipo",equipo.getTipo());
        }
    }


}
