package com.veterinariaXYZ.back.veterinariaXYZ.mapper;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RafDatosDuenoMapper implements RowMapper<Dueno> {

    @Override
    public Dueno mapRow(ResultSet resultSet, int i) throws SQLException {
        Dueno entity = new Dueno();
        entity.setDatosDuenoFromRs(resultSet);
        return entity;
    }
}