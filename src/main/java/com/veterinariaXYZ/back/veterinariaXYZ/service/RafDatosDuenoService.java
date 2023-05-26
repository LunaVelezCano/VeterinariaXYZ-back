package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;

import java.util.List;

public interface RafDatosDuenoService {

    Dueno save(Dueno application);

    Dueno update(Dueno application);

    List<Dueno> findAll();

    Dueno findOne(long nmidentificacion);
}
