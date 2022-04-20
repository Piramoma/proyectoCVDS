
insert into Recursos values (1, 'disponible','El quijote de la mancha', 'Bloque A', 'libro', 2, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (2, 'disponible','El Principito', 'Bloque A', 'libro', 4, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (3, 'disponible','Aprendiendo a Programar', 'Bloque G', 'libro', 3, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (4, 'disponible','El señor de los anillos', 'Bloque G', 'libro', 3, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (5, 'disponible','Lady masacre', 'Bloque A', 'libro', 2, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (6, 'disponible','Motomami', 'Bloque G', 'libro', 4, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (7, 'disponible','La Zorra', 'Bloque A', 'libro', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');

insert into Recursos values (8, 'disponible', 'Sala de Estudio 1', 'Bloque A', 'sala', 6, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (9, 'disponible', 'Sala de Estudio 2', 'Bloque A', 'sala', 6, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (10, 'disponible','Sala de Estudio 3', 'Bloque G', 'sala', 6, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (11, 'disponible','Sala de Estudio 4', 'Bloque G', 'sala', 6, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (12, 'disponible','Sala de Estudio 5', 'Bloque G', 'sala', 4, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (13, 'disponible','Sala de Estudio 6', 'Bloque G', 'sala', 4, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (14, 'disponible','Sala de Estudio 7', 'Bloque A', 'sala', 4, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');

insert into Recursos values (15, 'disponible','Equipo-1', 'Bloque A', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (16, 'disponible','Equipo-2', 'Bloque A', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (17, 'disponible','Equipo-3', 'Bloque G', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (18, 'disponible','Equipo-4', 'Bloque G', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (19, 'disponible','Equipo-5', 'Bloque A', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (20, 'disponible','Equipo-6', 'Bloque G', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');
insert into Recursos values (21, 'disponible','Equipo-7', 'Bloque A', 'equipo', 1, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');

insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D1', 'R1', '3/8/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D2', 'R2', '3/6/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D3', 'R3', '2/19/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D4', 'R4', '3/12/2022');
insert into Devoluciones (idDevolucion, idRecurso, fechaDevolucion) values ('D5', 'R5', '2/23/2022');

insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R1', 2161401, 1, '2022-04-11 09:08:39', '2022-04-27 11:55:31');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R2', 2161402, 2, '2022-04-03 02:32:53', '2022-04-20 15:49:51');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R3', 2161403, 3, '2022-04-10 15:52:32', '2022-04-19 11:49:48');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R4', 2161404, 4, '2022-04-11 01:16:05', '2022-04-29 03:50:27');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R5', 2161405, 5, '2022-04-02 09:18:34', '2022-04-29 02:05:22');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R6', 2161406, 6, '2022-04-14 20:32:40', '2022-04-28 20:00:31');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R7', 2161407, 7, '2022-04-05 16:01:02', '2022-04-27 06:59:15');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R8', 2161408, 8, '2022-04-01 12:28:57', '2022-04-25 08:28:52');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R9', 2161409, 9, '2022-04-03 04:47:35', '2022-04-27 23:48:44');
insert into Reservas (idReserva, idEstudiante, idRecurso, fechaInicio, fechaFinal) values ('R10', 2161410, 10, '2022-04-05 12:58:32', '2022-04-24 19:50:02');

insert into Usuarios (idUsuario, nombre, correo) values (2161401, 'Beckie', 'bmckerron0@accuweather.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161402, 'Pris', 'pkleinhaus1@hugedomains.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161403, 'Donica', 'dbenedtti2@ftc.gov');
insert into Usuarios (idUsuario, nombre, correo) values (2161404, 'Claybourne', 'cyewdell3@issuu.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161405, 'Pat', 'phannent4@columbia.edu');
insert into Usuarios (idUsuario, nombre, correo) values (2161406, 'Berny', 'btarpey5@blinklist.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161407, 'Hugues', 'hbeedom6@geocities.jp');
insert into Usuarios (idUsuario, nombre, correo) values (2161408, 'Kliment', 'kcawdell7@mashable.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161409, 'Pietra', 'pkobiera8@weather.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161410, 'Jonathon', 'jcunio9@naver.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161411, 'Miguelita', 'mbazyletsa@ning.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161412, 'Milka', 'mruppertzb@sakura.ne.jp');
insert into Usuarios (idUsuario, nombre, correo) values (2161413, 'Thurston', 'tbatteyc@ebay.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161414, 'Davida', 'dpourveerd@psu.edu');
insert into Usuarios (idUsuario, nombre, correo) values (2161415, 'Luis', 'lburnhille@goodreads.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161416, 'Kalina', 'kcromleyf@army.mil');
insert into Usuarios (idUsuario, nombre, correo) values (2161417, 'Mayne', 'mlauritseng@csmonitor.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161418, 'Wadsworth', 'wmiddlehursth@sitemeter.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161419, 'Dolores', 'dricardei@skyrock.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161420, 'Eliot', 'evausej@pinterest.com');
insert into Usuarios (idUsuario, nombre, correo) values (2161421, 'Beckie', 'bmckerron0@accuweather.com');

