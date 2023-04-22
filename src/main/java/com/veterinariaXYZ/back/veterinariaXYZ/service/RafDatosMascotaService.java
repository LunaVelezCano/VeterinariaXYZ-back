package com.veterinariaXYZ.back.veterinariaXYZ.service;

import com.veterinariaXYZ.back.veterinariaXYZ.dto.RafDatosMascota;
import java.util.List;

public interface RafDatosMascotaService {

    RafDatosMascota save(RafDatosMascota application);

    RafDatosMascota update(RafDatosMascota application);

    List<RafDatosMascota> findAll();

    RafDatosMascota findOne(int nmid);
}
