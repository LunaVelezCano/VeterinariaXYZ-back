CREATE TABLE IF NOT EXISTS 'Dueno'(
    'nmidentificacion' BIGINT NOT NULL,
    'dsT_identificacion' varchar (200),
    'dsnom_dueno' varchar (200),
    'dsciudad'  varchar (200),
    'dsdireccion' varchar (200),
    'nmtelefono' bigint,
    PRIMARY KEY ('nmidentificacion')
);
CREATE TABLE IF NOT EXISTS 'Mascota'(
     'nmid' int NOT NULL AUTOINCREMENT,
     'dsnom_mascota' varchar (200),
     'dsespecie' varchar (200),
     'dsraza' varchar (200),
     'dtf_nacimiento' DATE,
     'nmidentificacion_dueno' bigint,
     'dtf_registro' DATE,
     PRIMARY KEY ('nmid'),
     FOREIGN KEY (nmidentificacion_dueno) REFERENCES Dueno(nmidentificacion)
);


