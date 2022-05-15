insert into Usuarios values ('yesid.mora', 'Yesid','Mora', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('daniel.ramos', 'Daniel','Ramos', 'Sistemas', '12345', 'estudiante');
insert into Usuarios values ('admin', 'Admin','Admin', 'Admin', 'admin', 'admin');

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('101','disponible','Enamorate de ti', 'Bloque A', 'libro','3','Sergio Otero');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('102','disponible','El quijote de la mancha', 'Bloque A', 'libro', 2, 'Miguel de Cervantez');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('103','disponible','El Principito', 'Bloque A', 'libro', 2, 'Antoine de Saint-Exupéry');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('104','disponible','El fantasma de Canterville', 'Bloque A', 'libro', 4, 'Oscar Wilde');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('105','agotado','Aprendiendo a Programar', 'Bloque G', 'libro', 3, 'Patricia Salazar');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('106','agotado','El señor de los anillos', 'Bloque G', 'libro', 3, 'JR Tolkien');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('107','agotado','Lady masacre', 'Bloque A', 'libro', 2, 'Mia Amstrom');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('108','agotado','Motomami', 'Bloque G', 'libro', 4,'Estebanquito Cristancho');

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('201','disponible', 'Sala de Estudio 1', 'Bloque A', 'sala', 6, 'Tablero, 5 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('202','disponible', 'Sala de Estudio 2', 'Bloque A', 'sala', 6, 'Tablero, 5 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('203','disponible','Sala de Estudio 3', 'Bloque G', 'sala', 6, 'Tablero, 5 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('204','disponible','Sala de Estudio 4', 'Bloque G', 'sala', 6, 'Tablero, 5 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('205','agotado','Sala de Estudio 5', 'Bloque G', 'sala', 4, 'Tablero, 5 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('206','agotado','Sala de Estudio 6', 'Bloque G', 'sala', 4, 'Tablero, 7 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('207','agotado','Sala de Estudio 7', 'Bloque A', 'sala', 4, 'Tablero, 7 sillas');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('208','agotado','Sala de Estudio 8', 'Bloque A', 'sala', 4, 'Tablero, 7 sillas');

insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('302','disponible','Equipo-1', 'Bloque A', 'equipo', 1,'PC Escritorio, 8GB Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('303','disponible','Equipo-2', 'Bloque A', 'equipo', 1,'PC Escritorio, 8GB Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('304','disponible','Equipo-3', 'Bloque G', 'equipo', 1,'PC Escritorio, 8GB Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('305','agotado','Equipo-4', 'Bloque G', 'equipo', 1,'PC Escritorio, 8GB Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('306','agotado','Equipo-5', 'Bloque A', 'equipo', 1,'PC Escritorio, 16 Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('307','agotado','Equipo-6', 'Bloque G', 'equipo', 1,'PC Escritorio, 16Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('308','agotado','Equipo-7', 'Bloque A', 'equipo', 1,'PC Escritorio, 16 Ram, Disco SSH');
insert into Recursos(idinterno, estado, nombre, ubicacion, tipo, capacidad, descripcion) values ('301','disponible','Equipo-8', 'Bloque A', 'equipo', 1,'PC Escritorio, 32Ram, Disco SSH');

insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, proximaocurrencia, estado, diaactual)  values ('yesid.mora', 11, '2022-04-27', '2022-04-11 09:08:39', '2022-05-27 11:55:31',  true, '2022-11-11 09:08:39', 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, proximaocurrencia, estado, diaactual)  values ('yesid.mora', 12, '2022-04-27', '2022-05-03 02:32:53', '2022-06-20 15:49:51', true, '2022-12-11 09:08:39', 'activa','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('yesid.mora', 13, '2022-04-27', '2022-05-10 15:52:32', '2022-06-19 11:49:48',  false, 'terminada','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('yesid.mora', 14, '2022-04-27', '2022-06-11 01:16:05', '2022-07-29 03:50:27',  false, 'activa','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, proximaocurrencia, estado, diaactual)  values ('daniel.ramos', 15, '2022-04-27', '2022-06-02 09:18:34', '2022-08-29 02:05:22', true, '2022-12-11 09:08:39', 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, proximaocurrencia, estado, diaactual)  values ('daniel.ramos', 16, '2022-04-27', '2022-07-14 20:32:40', '2022-08-28 20:00:31',  true, '2022-12-11 09:08:39', 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('daniel.ramos', 17, '2022-04-27', '2022-07-05 16:01:02', '2022-08-27 06:59:15', false, 'activa','2022-05-02 06:00:00');

insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('daniel.ramos', 2, '2021-04-27', '2022-05-03 07:00:00', '2022-05-03 08:28:52', false, 'terminada','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('yesid.mora', 21, '2022-04-27', '2022-05-05 07:00:00', '2022-05-05 08:28:52', false, 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('daniel.ramos', 19, '2021-04-27', '2022-05-03 07:00:00', '2022-05-03 08:28:52', false, 'terminada','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('yesid.mora', 15, '2022-04-27', '2022-06-04 07:00:00', '2022-06-04 08:28:52', false, 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('daniel.ramos', 22, '2022-04-27', '2022-08-03 07:00:00', '2022-08-03 08:28:52', false, 'cancelado','2022-05-02 06:00:00');
insert into Reservas (idUsuario, idRecurso,  fechaSolicitud, fechaInicioReserva, fechaFinReserva, recurrente, estado, diaactual)  values ('yesid.mora', 2, '2021-04-27', '2022-05-03 07:00:00', '2022-05-03 08:28:52', false, 'terminada','2022-05-02 06:00:00');


insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('1', '2022-04-11', '09:20', '2022-04-12', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('2', '2022-04-12', '09:20', '2022-04-13', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('3', '2022-04-13', '09:20', '2022-04-14', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('11', '2022-04-14', '09:20', '2022-04-15', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('12', '2022-04-15', '09:20', '2022-04-16', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('13', '2022-04-16', '09:20', '2022-04-17', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('22', '2022-04-17', '09:20', '2022-04-18', '09:20');
insert into Horarios (idrecurso, fechainicio, horainicio, fechafin, horafin) values ('23', '2022-04-18', '09:20', '2022-04-19', '09:20');

insert into Horarios (idrecurso, fechainicio, fechafin) values ('1', '2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('2', '2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('3', '2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('11','2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('12','2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('13','2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('22','2022-05-03 09:08:39', '2022-05-04 09:08:39');
insert into Horarios (idrecurso, fechainicio, fechafin) values ('23','2022-05-03 09:08:39', '2022-05-04 09:08:39');