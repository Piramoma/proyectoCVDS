insert into Usuarios values ('yesid.mora', 'Yesid','Mora', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('daniel.ramos', 'Daniel','Ramos', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('juan.martinez', 'Juan','Martinez', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('sebastian.piñeros', 'Sebastian','Piñeros', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('admin', 'Admin','Admin', 'Admin', 'admin', 'admin');

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('101','disponible','Enamorate de ti', 'Bloque A', 'libro','3');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('102','disponible','El quijote de la mancha', 'Bloque A', 'libro', 2);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('103','disponible','El quijote de la mancha', 'Bloque A', 'libro', 2);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('104','disponible','El Principito', 'Bloque A', 'libro', 4);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('105','agotado','Aprendiendo a Programar', 'Bloque G', 'libro', 3);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('106','agotado','El señor de los anillos', 'Bloque G', 'libro', 3);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('107','agotado','Lady masacre', 'Bloque A', 'libro', 2);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('108','agotado','Motomami', 'Bloque G', 'libro', 4);

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('disponible', 'Sala de Estudio 1', 'Bloque A', 'sala', 6);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('202','disponible', 'Sala de Estudio 2', 'Bloque A', 'sala', 6);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('203','disponible','Sala de Estudio 3', 'Bloque G', 'sala', 6);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('204','disponible','Sala de Estudio 4', 'Bloque G', 'sala', 6);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('205','agotado','Sala de Estudio 5', 'Bloque G', 'sala', 4);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('206','agotado','Sala de Estudio 6', 'Bloque G', 'sala', 4);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('207','agotado','Sala de Estudio 7', 'Bloque A', 'sala', 4);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('208','agotado','Sala de Estudio 8', 'Bloque A', 'sala', 4);

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('302','disponible','Equipo-1', 'Bloque A', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('303','disponible','Equipo-2', 'Bloque A', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('304','disponible','Equipo-3', 'Bloque G', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('305','agotado','Equipo-4', 'Bloque G', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('306','agotado','Equipo-5', 'Bloque A', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('307','agotado','Equipo-6', 'Bloque G', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('308','agotado','Equipo-7', 'Bloque A', 'equipo', 1);
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad) values ('301','disponible','Equipo-8', 'Bloque A', 'equipo', 1);

insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('1', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('2', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('3', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('4', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('5', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('6', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('7', '2022-04-11 09:08:39', '2022-04-11 10:08:39');
insert into Disponibilidad (idrecurso, fechainicio, fechafin) values ('8', '2022-04-11 09:08:39', '2022-04-11 10:08:39');

insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 11, '2022-04-11 09:08:39', '2022-04-27 11:55:31', '2022-04-27', 'cancelado');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 12, '2022-04-03 02:32:53', '2022-04-20 15:49:51', '2022-04-27', 'activa');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 13, '2022-04-10 15:52:32', '2022-04-19 11:49:48', '2022-04-27', 'terminada');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 14, '2022-04-11 01:16:05', '2022-04-29 03:50:27', '2022-04-27', 'activa');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 15, '2022-04-02 09:18:34', '2022-04-29 02:05:22', '2022-04-27', 'cancelado');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 16, '2022-04-14 20:32:40', '2022-04-28 20:00:31', '2022-04-27', 'cancelado');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 17, '2022-04-05 16:01:02', '2022-04-27 06:59:15', '2022-04-27', 'terminada');
insert into Reservas (idUsuario, idRecurso, fechaInicioReserva, fechaFinReserva, fechaSolicitud, estado) values ('yesid.mora', 17, '2022-04-01 12:28:57', '2022-04-25 08:28:52', '2022-04-27', 'terminada');

insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D1', 'R1', '3/8/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D2', 'R2', '3/6/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D3', 'R3', '2/19/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D4', 'R4', '3/12/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D5', 'R5', '2/23/2022');