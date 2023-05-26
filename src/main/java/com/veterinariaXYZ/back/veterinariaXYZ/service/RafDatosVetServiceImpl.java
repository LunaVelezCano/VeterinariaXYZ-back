package com.veterinariaXYZ.back.veterinariaXYZ.service;


import com.veterinariaXYZ.back.veterinariaXYZ.dao.RafDatosVetDAO;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RafDatosVetServiceImpl implements RafDatosVetService {

    private  final Logger log = LoggerFactory.getLogger(RafDatosVetServiceImpl.class);
    private final RafDatosVetDAO raf_datosvetDAO;

    public RafDatosVetServiceImpl(RafDatosVetDAO raf_datosvetDAO) { this.raf_datosvetDAO = raf_datosvetDAO; }

    @Override
    public Veterinario save(Veterinario raf_datosvet){
        log.debug("Request to insert raf_datosvet: {}", raf_datosvet);
        return raf_datosvetDAO.insert(raf_datosvet);
    }
    @Override
    public Veterinario update(Veterinario raf_datosvet){
        log.debug("Request to get all raf_datosvet : {}", raf_datosvet);
        return raf_datosvetDAO.update(raf_datosvet);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Veterinario> findAll() {
        log.debug("Request to get all raf_datosvet");
        return raf_datosvetDAO.getAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Veterinario findOne(long nmidenti_vet) {
        log.debug("Request to get raf_datosvet : {}", nmidenti_vet);
        return raf_datosvetDAO.getById(nmidenti_vet);
    }
}
