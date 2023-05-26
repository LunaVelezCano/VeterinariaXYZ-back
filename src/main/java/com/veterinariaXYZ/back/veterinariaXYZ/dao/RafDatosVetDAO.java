package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;

import java.util.List;

public interface RafDatosVetDAO {

    List<Veterinario> getAll();

   Veterinario getById(long nmidenti_vet);

    Veterinario insert(Veterinario entity);

    Veterinario update(Veterinario entity);

}
