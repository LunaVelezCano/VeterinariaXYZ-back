package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.dao.RafDatosDuenoDAO;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public  class RafDatosDuenoServiceImpl  implements RafDatosDuenoService {

    private  final Logger log = LoggerFactory.getLogger(RafDatosDuenoServiceImpl.class);
    private final RafDatosDuenoDAO raf_datosduenoDAO;

    public RafDatosDuenoServiceImpl(RafDatosDuenoDAO raf_datosduenoDAO) { this.raf_datosduenoDAO = raf_datosduenoDAO; }

    @Override
    public Dueno save(Dueno raf_datosdueno){
        log.debug("Request to insert raf_datosdueno: {}", raf_datosdueno);
        return raf_datosduenoDAO.insert(raf_datosdueno);
    }
    @Override
    public Dueno update(Dueno raf_datosdueno){
        log.debug("Request to get all raf_datosdueno : {}", raf_datosdueno);
        return raf_datosduenoDAO.update(raf_datosdueno);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Dueno> findAll() {
        log.debug("Request to get all raf_datosdueno");
        return raf_datosduenoDAO.getAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Dueno findOne(long nmidentificacion) {
        log.debug("Request to get raf_datosdueno : {}", nmidentificacion);
        return raf_datosduenoDAO.getById(nmidentificacion);
    }

}
