package edu.eci.cvds.tests;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBibliotecaFactory;
import edu.eci.cvds.services.ServiciosBiblioteca;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReservaTest {

    ServiciosBiblioteca serviciosBiblioteca;

    public ReservaTest(){
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }

    @Before
    public void setUp(){
    }

    @Test
    public void deberiaConsultarReservasCanceladasDeUsuario(){
        List<Reserva> reservasCanceladas = null;
        try {
            reservasCanceladas = serviciosBiblioteca.consultarReservasCanceladas("daniel.ramos");
            for (Reserva reserva: reservasCanceladas){
                Assert.assertEquals("daniel.ramos",reserva.getIdUsuario());
                Assert.assertEquals("cancelado",reserva.getEstado());
            }
            reservasCanceladas = serviciosBiblioteca.consultarReservasCanceladas("yesid.mora");
            for (Reserva reserva: reservasCanceladas){
                Assert.assertEquals("yesid.mora",reserva.getIdUsuario());
                Assert.assertEquals("cancelado",reserva.getEstado());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se puedo consultar las reservas de un usuario");
        }
    }

    @Test
    public void deberiaConsultarReservasTerminadasDeUsuario(){
        List<Reserva> reservasCanceladas = null;
        try {
            reservasCanceladas = serviciosBiblioteca.consultarReservasPasadas("daniel.ramos");
            for (Reserva reserva: reservasCanceladas){
                Assert.assertEquals("daniel.ramos",reserva.getIdUsuario());
                Assert.assertEquals("terminada",reserva.getEstado());
            }
            reservasCanceladas = serviciosBiblioteca.consultarReservasPasadas("yesid.mora");
            for (Reserva reserva: reservasCanceladas){
                Assert.assertEquals("yesid.mora",reserva.getIdUsuario());
                Assert.assertEquals("terminada",reserva.getEstado());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se puedo consultar las reservas de un usuario");
        }
    }

    @Test
    public void deberiaConsultarLasReservasDeUnRecurso(){
        List<Reserva> reservas = null;
        try {
            reservas = serviciosBiblioteca.listarReservasRecurso(16);
            for(Reserva reserva:reservas){
                Assert.assertEquals(16,reserva.getIdRecurso());
            }
            reservas = serviciosBiblioteca.listarReservasRecurso(52);
            for(Reserva reserva:reservas){
                Assert.assertEquals(52,reserva.getIdRecurso());
            }
        } catch (PersistenceException e) {
            Assert.fail("No se puedo consultar las reservas de un usuario");
        }
    }
}
