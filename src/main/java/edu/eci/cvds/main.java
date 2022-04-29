package edu.eci.cvds;

import edu.eci.cvds.entities.Recurso;
import edu.eci.cvds.entities.Reserva;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ServiciosBiblioteca;
import edu.eci.cvds.services.ServiciosBibliotecaFactory;

import java.util.List;

//https://proyecto-cvds-piramoma.herokuapp.com
public class main {
    public static void main(String[] args) throws PersistenceException {
        ServiciosBiblioteca instance = ServiciosBibliotecaFactory.getInstance().getServiciosBiblioteca();
        System.out.println("Recursos Libros");
        List<Recurso> Recursolibros = instance.consultarLibros();
        for(Recurso r: Recursolibros){
            System.out.println(r.toString());
        }
        System.out.println("Recursos Equipos");
        List<Recurso> RecursoEquipos = instance.consultarEquipos();
        for(Recurso r: RecursoEquipos){
            System.out.println(r.toString());
        }
        System.out.println("Recursos Salas");
        List<Recurso> RecursosSalas = instance.consultarSalasEstudio();
        for(Recurso r: RecursosSalas){
            System.out.println(r.toString());
        }
        System.out.println("Usuarios con Reservas");
        List<Usuario> usuariosConReservas = instance.consultarUsuariosConReservas();
        for(Usuario u: usuariosConReservas){
            System.out.println(u.toString());
        }
        System.out.println("Reservas con mucha informacion");
        List<Reserva> reservaMuchaInfo = instance.consultarPorUsuarioMuchaInfo("yesid.mora");
        for(Reserva r: reservaMuchaInfo){
            System.out.println(r.toString());
        }
    }
}
