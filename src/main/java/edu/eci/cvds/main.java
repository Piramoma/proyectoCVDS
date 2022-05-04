package edu.eci.cvds;

import edu.eci.cvds.entities.Horario;
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

        //Reservas Recurso
        //instance.nuevoRecurso(1002, "disponible", "Awa", "Bloque G", "libro", 5, "Daniel Ramos");

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
        System.out.println("Reservas De Usuario");
        List<Reserva> reservasuser = instance.consultarPorUsuarioPocaInfo("yesid.mora");
        for(Reserva r: reservasuser){
            System.out.println(r.toString());
        }
        System.out.println("Horarios");
        List<Horario> horarios = instance.consultarHorarios();
        for(Horario h: horarios){
            System.out.println(h.toString());
        }

        System.out.println("Consultar reservas Pasadas");
        List<Reserva> reservasPasadas = instance.consultarReservasPasadas("yesid.mora");
        for(Reserva r: reservasPasadas){
            System.out.println(r.toString());
        }

        System.out.println("Consultar reservas Canceladas");
        List<Reserva> reservasCanceladas = instance.consultarReservasCanceladas("yesid.mora");
        for(Reserva r: reservasCanceladas){
            System.out.println(r.toString());
        }

        System.out.println("Reservas de un recurso");
        List<Reserva> reservasRecurso = instance.listarReservasRecurso(17);
        for(Reserva r: reservasRecurso){
            System.out.println(r.toString());
        }

        System.out.println("Consultar Recurso Horarios");
        List<Horario> horariosRecurso = instance.consultaHorariosRecurso(1);
        for(Horario r: horariosRecurso){
            System.out.println(r.toString());
        }

        System.out.println("Consultar Horario Especifico");
        Horario horarioespecifico = instance.consultarHorario(1, 1);
        System.out.println(horarioespecifico.toString());

    }
}
