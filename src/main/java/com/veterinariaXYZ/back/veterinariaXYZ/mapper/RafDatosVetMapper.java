package com.veterinariaXYZ.back.veterinariaXYZ.mapper;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RafDatosVetMapper implements RowMapper<Veterinario> {

    @Override
    public Veterinario mapRow(ResultSet resultSet, int i) throws SQLException {
        Veterinario entity = new Veterinario();
        entity.setDatosVetFromRs(resultSet);
        return entity;
    }

}
