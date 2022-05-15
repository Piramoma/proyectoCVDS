CREATE TABLE horarios (
   id serial NOT NULL,
   idrecurso int4 NOT NULL,
   fechainicio DATE NOT NULL,
   horainicio varchar NOT NULL,
   fechafin DATE NOT NULL,
   horafin varchar NOT NULL
);

CREATE TABLE recursos (
     id serial NOT NULL,
  	 idInterno int4 NOT NULL,
     estado varchar(100) NOT NULL,
     nombre varchar(100) NOT NULL,
     ubicacion varchar(100) NOT NULL,
     tipo varchar(100) NOT NULL,
     capacidad int4 NOT NULL,
     descripcion varchar(100) NOT NULL
);

CREATE TABLE reservas (
      id serial NOT NULL,
      idUsuario varchar(200) NULL,
      idRecurso int4 NULL,
      fechaSolicitud date NULL,
      fechaInicioReserva timestamp NULL,
      fechaFinReserva timestamp NULL,
  	  recurrente bool NOT NULL,
  	  proximaocurrencia timestamp NULL,
      estado varchar(20) NULL,
      diaActual timestamp NOT NULL
);

CREATE TABLE usuarios (
    email varchar(200) NOT NULL,
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    programa varchar(100) NOT NULL,
    contraseña varchar(32) NOT NULL,
    tipo varchar(32) NULL
);

//drop table nombre_tabla
//ALTER TABLE nombre_tabla DROP CONSTRAINT fk_nombre

ALTER TABLE usuarios add PRIMARY KEY (email);
//ALTER TABLE recursos add PRIMARY KEY (id);
//ALTER TABLE reservas add PRIMARY KEY (id);
//ALTER TABLE horarios add PRIMARY KEY (id);

ALTER TABLE RECURSOS ADD CONSTRAINT UK_RECURSOS_idInterno UNIQUE (idInterno);

ALTER TABLE RESERVAS ADD CONSTRAINT FK_RESERVAS_USUARIOS FOREIGN KEY ( idUsuario )
REFERENCES USUARIOS ( email );

ALTER TABLE RESERVAS ADD CONSTRAINT FK_RESERVAS_RECURSOS FOREIGN KEY ( idRecurso )
REFERENCES RECURSOS ( id );

ALTER TABLE HORARIOS ADD CONSTRAINT FK_Horario_idRecurso FOREIGN KEY ( idrecurso )
REFERENCES RECURSOS ( id );