package com.veterinariaXYZ.back.veterinariaXYZ.mapper;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Mascota;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RafDatosMascotaMapper implements RowMapper <Mascota> {

    @Override
    public Mascota mapRow(ResultSet resultSet, int i) throws SQLException {
        Mascota entity = new Mascota();
        entity.setDatosMascotaFromRs(resultSet);
        return entity;
    }
}

