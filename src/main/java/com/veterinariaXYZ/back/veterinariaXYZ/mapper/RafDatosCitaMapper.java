package com.veterinariaXYZ.back.veterinariaXYZ.mapper;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RafDatosCitaMapper  implements RowMapper<Cita> {

    @Override
    public Cita mapRow(ResultSet resultSet, int i) throws SQLException {
        Cita entity = new Cita();
        entity.setDatosCitaFromRs(resultSet);
        return entity;
    }
}
