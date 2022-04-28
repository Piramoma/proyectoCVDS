CREATE TABLE disponibilidad (
   id serial NOT NULL,
   idrecurso int4 NOT NULL,
   fechainicio timestamp NOT NULL,
   fechafin timestamp NOT NULL
);

CREATE TABLE recursos (
     id serial NOT NULL,
  	 idInterno int4 NOT NULL,
     estado varchar(100) NOT NULL,
     nombre varchar(100) NOT NULL,
     ubicacion varchar(100) NOT NULL,
     tipo varchar(100) NOT NULL,
     capacidad int4 NOT NULL
);

CREATE TABLE reservas (
      id serial NOT NULL,
      idUsuario varchar(200) NULL,
      idRecurso int4 NULL,
      fechaInicioReserva timestamp NULL,
      fechaFinReserva timestamp NULL,
      fechaSolicitud date NULL,
      estado varchar(20) NULL
);

CREATE TABLE usuarios (
    email varchar(200) NOT NULL,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    programa varchar(100) NOT NULL,
    contraseña varchar(32) NOT NULL,
    tipo varchar(32) NULL
);

ALTER TABLE usuarios add PRIMARY KEY (email);
//ALTER TABLE recursos add PRIMARY KEY (id);
//ALTER TABLE reservas add PRIMARY KEY (id);
//ALTER TABLE disponibilidad add PRIMARY KEY (id);

ALTER TABLE RECURSOS ADD CONSTRAINT UK_RECURSOS_idInterno UNIQUE (idInterno);

ALTER TABLE RESERVAS ADD CONSTRAINT FK_RESERVAS_USUARIOS FOREIGN KEY ( idUsuario )
REFERENCES USUARIOS ( email );
ALTER TABLE RESERVAS ADD CONSTRAINT FK_RESERVAS_RECURSOS FOREIGN KEY ( idRecurso )
REFERENCES RECURSOS ( id );
ALTER TABLE DISPONIBILIDAD ADD CONSTRAINT FK_DISPONIBILIDAD_idRecurso FOREIGN KEY ( idrecurso )
REFERENCES RECURSOS ( id );