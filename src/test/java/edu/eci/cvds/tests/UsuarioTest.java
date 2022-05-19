package edu.eci.cvds.tests;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.exception.PersistenceException;
import edu.eci.cvds.services.ServiciosBiblioteca;
import edu.eci.cvds.services.ServiciosBibliotecaFactory;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

    ServiciosBiblioteca serviciosBiblioteca;

    public UsuarioTest(){
        serviciosBiblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
    }

    @Test
    public void deberiaConsultarNombreDeUsuario(){
        Usuario usuario = null;
        try {
            usuario = serviciosBiblioteca.consultarNombreUsuario("daniel.ramos");
            Assert.assertEquals("Daniel", usuario.getNombre());
            Assert.assertEquals("Ramos", usuario.getApellido());

            usuario = serviciosBiblioteca.consultarNombreUsuario("yesid.mora");
            Assert.assertEquals("Yesid", usuario.getNombre());
            Assert.assertEquals("Mora", usuario.getApellido());

            usuario = serviciosBiblioteca.consultarNombreUsuario("admin");
            Assert.assertEquals("Admin", usuario.getNombre());
            Assert.assertEquals("Admin", usuario.getApellido());
        } catch (PersistenceException e) {
            Assert.fail("No se logro consultar todos las salas");
        }
    }

}
