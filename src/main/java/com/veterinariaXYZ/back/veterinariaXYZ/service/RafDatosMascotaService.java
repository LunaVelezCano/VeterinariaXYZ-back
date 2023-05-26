package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Mascota;

import java.util.List;

public interface RafDatosMascotaService {

    Mascota save(Mascota application);

    Mascota update(Mascota application);

    List<Mascota> findAll();

    Mascota findOne(int nmid);
    List<Mascota> findByNmidentificacionDueno(long nmidentificacion_dueno);


}
