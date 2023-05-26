package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.dao.RafDatosCitaDAO;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RafDatosCitaServiceImpl implements RafDatosCitaService {

    private  final Logger log = LoggerFactory.getLogger(RafDatosCitaServiceImpl.class);

    private final RafDatosCitaDAO raf_datoscitaDAO;

    public RafDatosCitaServiceImpl(RafDatosCitaDAO raf_datoscitaDAO) { this.raf_datoscitaDAO = raf_datoscitaDAO; }

    @Override
    public Cita save(Cita raf_datoscita){
        log.debug("Request to insert raf_datoscita: {}", raf_datoscita);
        return raf_datoscitaDAO.insert(raf_datoscita);
    }

    @Override
    public Cita update(Cita raf_datoscita){
        log.debug("Request to update raf_datoscita : {}", raf_datoscita);
        return raf_datoscitaDAO.update(raf_datoscita);
    }
    @Override
    @Transactional(readOnly = true)
    public Cita delete(Cita raf_datoscita) {
      log.debug ("Request to delete raf_datoscita : {}", raf_datoscita);
    return raf_datoscitaDAO.delete(raf_datoscita);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        log.debug("Request to get all raf_datoscita");
        return raf_datoscitaDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita findOne(int nmid) {
        log.debug("Request to get raf_datoscita : {}", nmid);
        return raf_datoscitaDAO.getById(nmid);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Cita> findByNmidentificacionDueno(long nmidentificacion_dueno) {
        log.debug("Request to get raf_datosmascota : {}", nmidentificacion_dueno);
        return raf_datoscitaDAO.getByidentificacionDueno(nmidentificacion_dueno);
    }



}
