<<<<<<< HEAD
CREATE TABLE disponibilidad (
   id int4 NOT NULL,
   idrecurso int4 NOT NULL,
   fechainicio timestamp NOT NULL,
   fechafin timestamp NOT NULL
);

CREATE TABLE recursos (
     id int4 NOT NULL,
     estado varchar(100) NOT NULL,
     nombre varchar(100) NOT NULL,
     ubicacion varchar(100) NOT NULL,
     tipo varchar(100) NOT NULL,
     capacidad int4 NOT NULL,
     horainicio timestamp NULL,
     horafin timestamp NULL
);

CREATE TABLE reservas (
     id int4 NOT NULL,
     id_usuario varchar(200) NULL,
     id_recurso int4 NULL,
     fecha_inicio_reserva timestamp NULL,
     fecha_fin_reserva timestamp NULL,
     fecha_solicitud date NULL,
     tipo varchar NULL,
     activa bool NULL
);


CREATE TABLE usuarios (
    email varchar(200) NOT NULL,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    contraseña varchar(32) NOT NULL,
    tipo varchar(32) NULL
);

ALTER TABLE usuarios add PRIMARY KEY (email);
ALTER TABLE recursos add PRIMARY KEY (id);
ALTER TABLE reservas add PRIMARY KEY (id);
ALTER TABLE disponibilidad add PRIMARY KEY (id);

insert into Recursos values (1, 'disponible','El quijote de la mancha', 'Bloque A', 'libro', 2, '2022-06-22 19:10:25-07', '2022-06-23 19:10:25-07');

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

insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (1, 'Computador Asus', false, 'Computador', 'Computador en perfectas condiciones', 'Bloque A', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (2, 'El quijote de la mancha', true, 'Libro', 'Libro escrito por Gonzalo Jimenez de Quesada', 'Bloque A', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (3, 'Computador Acer', false, 'Computador', 'Computador con fallo en la barra espaciadora', 'Bloque B', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (4, 'El Perfume', false, 'Libro', 'Novela escrita por Patrick Süskind publicada en 1985 ', 'Bloque B', 2);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (5, 'Sala de estudio 1', true, 'Sala de estudio', 'Sala de estudio con 1 mesa y 6 sillas', 'Bloque B', 2);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (6, 'Sala de estudio 2', true, 'Sala de estudio', 'Sala de estudio con 2 mesas y 3 sillas', 'Bloque A', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (7, 'Aprendiendo a Programar desde a partir de cero', false, 'Libro', 'Libro escrito por Patricia Salazar', 'Bloque A', 3);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (8, 'Sala de estudio 3', false, 'Sala de estudio', 'Sala de estudio con 2 mesas y 7 sillas', 'Bloque A', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (9, 'Computador Toshiba', true, 'Computador', 'Computador en buen estado, tiene un rayon en la pantalla', 'Bloque A', 2);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (10, 'Calculo a partir de una Variable', true, 'Libro', 'Libro escrito por James Stewart, septima edicion', 'Bloque A', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (11, 'Ecuaciones diferenciales con aplicaciones de modelado', false, 'Libro', 'Libro escrito por Dennis Zill, 9 edicion', 'Bloque A', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (12, 'Computador Lenovo', true, 'Computador', 'Computador en perfectas condiciones', 'Bloque B', 3);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (13, 'Sala de estudio 4', false, 'Sala de Estudio', 'Sala de estudio con 1 mesa y 4 sillas', 'Bloque A', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (14, 'Sala de estudio 5', true, 'Sala de Estudio', 'Sala de estudio con 1 mesa y 5 sillas', 'Bloque A', 2);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (15, 'Probabilidad y estadistica para ingenieria y ciencias', false, 'Libro escrito por Walpole, novena edicion', 'b', 'Bloque A', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (16, 'Computador HP', false, 'Computador', 'Computador en excelentes condiciones', 'Bloque B', 4);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (17, 'Sala de estudio 6', true, 'Sala de estudio', 'Sala de estudio con 2 mesas y 5 sillas', 'Bloque B', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (18, 'Principios de Economia', true, 'Libro', 'Libro escrito por Gregory Mankiw, publicado en 2009', 'Bloque B', 2);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (19, 'Sala de estudio 7', true, 'Sala de estudio', 'Sala destudio con 1 mesa y 2 sillas', 'Bloque B', 1);
insert into Recursos (idRecurso, nombre, disponible, tipo, descripcion, ubicacion, capacidad) values (20, 'Algebra de Baldor', false, 'Libro', 'Libro escrito por Aurelio Baldor, publicado en 1941', 'Bloque B', 4);