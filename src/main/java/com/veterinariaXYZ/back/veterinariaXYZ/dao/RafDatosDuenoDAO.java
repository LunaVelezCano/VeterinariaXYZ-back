package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;

import java.util.List;

public interface RafDatosDuenoDAO {

    List<Dueno> getAll();

    Dueno getById(long nmidentificacion);

    Dueno insert(Dueno entity);
    Dueno update(Dueno entity);

}
