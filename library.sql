CREATE TABLE disponibilidad (
   id int4 NOT NULL,
   idrecurso int4 NOT NULL,
   fechainicio time NOT NULL,
   fechafin time NOT NULL
);

CREATE TABLE recursos (
     id int4 NOT NULL,
     estado varchar(100) NOT NULL,
     nombre varchar(100) NOT NULL,
     ubicacion varchar(100) NOT NULL,
     tipo varchar(100) NOT NULL,
     capacidad int4 NOT NULL,
     horainicio time NULL,
     horafin time NULL
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

ALTER TABLE Tipo_Usuario add PRIMARY KEY (id);
ALTER TABLE Usuarios add PRIMARY KEY (email);

Alter table usuarios add constraint fk_usuarios_tipo_usuarios
    foreign key (tipo_usuario_id)
        references tipo_usuario(id)
;