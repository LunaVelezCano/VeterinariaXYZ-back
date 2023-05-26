package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Mascota;

import java.util.List;

public interface RafDatosMascotaDAO {

    List<Mascota> getAll();

    Mascota getById(int nmid);

    Mascota insert(Mascota entity);

    Mascota update(Mascota entity);

    List<Mascota> getByidentificacionDueno(long nmidentificacion_dueno);

}
