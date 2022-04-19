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