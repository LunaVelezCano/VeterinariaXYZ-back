package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;

import java.util.List;

public interface RafDatosCitaDAO {

    List<Cita> getAll();

    Cita getById(int nmid);

    Cita insert(Cita entity);

    Cita update(Cita entity);

    Cita delete (Cita entity);

    List<Cita> getByidentificacionDueno(long nmidentificacion_dueno);

}
