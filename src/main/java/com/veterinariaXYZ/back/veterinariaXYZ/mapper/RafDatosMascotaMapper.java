package com.veterinariaXYZ.back.veterinariaXYZ.mapper;

import com.veterinariaXYZ.back.veterinariaXYZ.dto.RafDatosMascota;
import com.veterinariaXYZ.back.veterinariaXYZ.util.UtilDate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RafDatosMascotaMapper implements RowMapper <RafDatosMascota> {

    @Override
    public RafDatosMascota mapRow(ResultSet resultSet, int i) throws SQLException {

        RafDatosMascota entity = new RafDatosMascota();
        entity.setNmid(resultSet.getInt("nmid"));
        entity.setDsnom_mascota(resultSet.getString("dsnom_mascota"));
        entity.setDsespecie(resultSet.getString("dsespecie"));
        entity.setDsraza(resultSet.getString("dsraza"));
        entity.setDtf_nacimiento(UtilDate.getLocalDate(resultSet.getDate("dtf_nacimiento")));
        entity.setDsT_identificacion(resultSet.getString("dsT_identificacion"));
        entity.setNmidentificacion(resultSet.getInt("nmidentificacion"));
        entity.setDsnom_dueno(resultSet.getString("dsnom_dueno"));
        entity.setDsciudad(resultSet.getString("dsciudad"));
        entity.setDsdireccion(resultSet.getString("dsdireccion"));
        entity.setNmtelefono(resultSet.getInt("nmtelefono"));
        entity.setDtf_registro(UtilDate.getLocalDate(resultSet.getDate("dtf_registro")));

        entity.setDatosMascotaFromRs(resultSet);
        return entity;
    }
}

