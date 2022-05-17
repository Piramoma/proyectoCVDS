/*
 * Copyright (C) 2015
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.persistence.exception;

/**
 * Excepción de persistencia
 */
public class PersistenceException extends Exception {

    /**
     * Default generated servial version id
     */
    private static final long serialVersionUID = 7489763091920168317L;

    public static final String noSePuedeConsultarUsuariosConReservas = "No se puede consultar los usuarios que tienen reservas activas";
    public static final String errorAlRegistrarNuevoRecurso = "No se puedo registrar el recurso";
    public static final String noSeEncuentraAlUsuario = "No se ha podido encontrar al usuario solicitado";
    public static final String idInternoRepetido = "El id interno puesto ya se encuentra registrado en la base de datos";
    public static final String noSePuedeConsultarRecursosPorId = "No se ha podido consultar el recurso solicitado";
    public static final String noSePuedeConsultarPocaInfoPorUsuario = "No se puedo hacer la consulta de poca información por usuario";
    public static final String noSePuedeConsultarMuchaInfoPorUsuario = "No se puedo hacer la consulta de mucha información por usuario";
    public static final String noSePuedeconsultarHistorialDeReservas = "Ha ocurrido un error al consultar el historial de reservas";
    public static final String noSePuedeConsultarReservasCanceladas = "Ha Ocurrido un error al consultar las reservas canceladas";
    public static final String noSePuedeConsultarLasReservasDeUnRecurso = "Ha Ocurrido un error al consultar las reservas especificas del recurso";
    public static final String errorAlConsultarUnaReserva = "No se ha encontrada la reserva deseada";
    public static final String errorAlRegistrarNuevaReserva = "No se ha podido registrar la reserva deseada";
    public static final String noSePuedeConsultarLosHorarios = "Ha ocurrido un error al consultar los horarios";
    public static final String errorAlconsultarHorariosDeUnRecurso = "No se ha podido consultar los horarios del recurso especificado";


    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
