package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;

import java.util.List;

public interface RafDatosCitaService {

    Cita save(Cita application);

    Cita update(Cita application);

    List<Cita> findAll();

    Cita findOne(int nmid);

    List<Cita> findByNmidentificacionDueno(long nmidentificacion_dueno);

    Cita delete (Cita application);
}
