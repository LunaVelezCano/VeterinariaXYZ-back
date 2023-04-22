package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.dao.RafDatosMascotaDAO;
import com.veterinariaXYZ.back.veterinariaXYZ.dto.RafDatosMascota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional

public class RafDatosMascotaServiceImpl implements RafDatosMascotaService {

    private  final Logger log = LoggerFactory.getLogger(RafDatosMascotaServiceImpl.class);

    private final RafDatosMascotaDAO raf_datosmascotaDAO;

    public RafDatosMascotaServiceImpl(RafDatosMascotaDAO raf_datosmascotaDAO) { this.raf_datosmascotaDAO = raf_datosmascotaDAO; }

    @Override
    public RafDatosMascota save(RafDatosMascota raf_datosmascota){
        log.debug("Request to insert raf_datosmascota: {}", raf_datosmascota);
        return raf_datosmascotaDAO.insert(raf_datosmascota);
    }

    @Override
    public RafDatosMascota update(RafDatosMascota raf_datosmascota){
        log.debug("Request to get all raf_datosmascota : {}", raf_datosmascota);
        return raf_datosmascotaDAO.update(raf_datosmascota);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RafDatosMascota> findAll() {
        log.debug("Request to get all raf_datosmascota");
        return raf_datosmascotaDAO.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RafDatosMascota findOne(int nmid) {
        log.debug("Request to get raf_datosmascota : {}", nmid);
        return raf_datosmascotaDAO.getById(nmid);
    }
}
