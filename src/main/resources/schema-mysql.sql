CREATE TABLE IF NOT EXISTS 'raf_DatosMascota'(

   'nmid' int NOT NULL AUTOINCREMENT,
   'dsnom_mascota' varchar (200),
   'dsespecie' varchar (200),
   'dsraza' varchar (200),
   'dtf_nacimiento' DATE,
   'dsT_identificacion' varchar (200),
   'nmidentificacion' int,
   'dsnom_dueno' varchar (200),
   'dsciudad'  varchar (200),
   'dsdireccion' varchar (200),
   'nmtelefono' int,
   'dtf_registro' DATE,
   PRIMARY KEY ('nmid')

);
