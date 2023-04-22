package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.dto.RafDatosMascota;
import java.util.List;

public interface RafDatosMascotaDAO {

    List<RafDatosMascota> getAll();

    RafDatosMascota getById(int nmid);

    RafDatosMascota insert(RafDatosMascota entity);

    RafDatosMascota update(RafDatosMascota entity);


}
