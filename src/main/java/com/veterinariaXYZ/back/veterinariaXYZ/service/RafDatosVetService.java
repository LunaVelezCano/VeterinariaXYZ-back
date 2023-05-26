package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;

import java.util.List;

public interface RafDatosVetService {

    Veterinario save(Veterinario application);

    Veterinario update(Veterinario application);

    List<Veterinario> findAll();

    Veterinario findOne(long nmidenti_vet);
}


