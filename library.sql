CREATE TABLE Usuarios(
    idUsuario NUMERIC(10) NOT NULL,
    nombre VARCHAR(15) NOT NULL,
    correo VARCHAR(30) NOT NULL,
    CONSTRAINT "PK_Usuarios" PRIMARY KEY(idUsuario)
);

CREATE TABLE Recursos(
    idRecurso NUMERIC(15) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    disponible BOOLEAN NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(15) NOT NULL,
    capacidad NUMERIC(3),
    CONSTRAINT "PK_Recursos" PRIMARY KEY(idRecurso)
);

CREATE TABLE Reservas(
    idReserva NUMERIC(15) NOT NULL,
    idEstudiante NUMERIC(10) NOT NULL,
    idRecurso NUMERIC(15) NOT NULL,
    fechaInicio TIMESTAMP,
    fechaFinal TIMESTAMP,
    CONSTRAINT "PK_Reservas" PRIMARY KEY(idReserva),
    CONSTRAINT "FK_ReservaEstudiante" FOREIGN KEY(idEstudiante)
        REFERENCES Usuarios(idUsuario),
    CONSTRAINT "FK_ReservaRecurso" FOREIGN KEY(idRecurso)
        REFERENCES Recursos(idRecurso)
);

CREATE TABLE Devoluciones(
    idDevolucion NUMERIC(15) NOT NULL,
    idRecurso NUMERIC(15) NOT NULL,
    fechaDevolucion TIMESTAMP,
    CONSTRAINT "PK_Devoluciones" PRIMARY KEY(idDevolucion),
    CONSTRAINT "FK_DevolucionRecurso" FOREIGN KEY(idRecurso)
        REFERENCES Recursos(idRecurso)
);