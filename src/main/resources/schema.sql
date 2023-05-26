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

CREATE TABLE IF NOT EXISTS 'Veterinario'(
     'nmidenti_vet' BIGINT NOT NULL,
     'dsnom_vet' varchar (200),
     'nmtelefono' bigint,
     PRIMARY KEY ('nmidenti_vet')
);

CREATE TABLE IF NOT EXISTS 'Cita'(
      'nmid' int NOT NULL AUTOINCREMENT,
      'dsnom_mascota' varchar (200),
      'dtf_cita' DATE,
      'hr_cita' varchar (200),
      'nmid_vet' BIGINT NOT NULL,
      'nmidentificacion_dueno' bigint NOT NULL,
     PRIMARY KEY ('nmid'),
     FOREIGN KEY (nmidentificacion_dueno) REFERENCES Dueno(nmidentificacion),
     FOREIGN KEY (nmid_vet) REFERENCES Veterinario(nmidenti_vet),

);
