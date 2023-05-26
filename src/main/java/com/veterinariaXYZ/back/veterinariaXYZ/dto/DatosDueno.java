package com.veterinariaXYZ.back.veterinariaXYZ.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@EqualsAndHashCode()
public class DatosDueno implements Serializable {
    private static final long serialVersionUID = 1L;

    private long nmidentificacion;
    private String dsT_identificacion;
    private String dsnom_dueno;
    private String dsciudad;
    private String dsdireccion;
    private long nmtelefono;

    @JsonIgnore
    public void setDatosMascotaFromRs(ResultSet rs) throws SQLException {
        nmidentificacion = rs.getLong("nmidentificacion");
        dsT_identificacion = rs.getString("dsT_identificacion");
        dsnom_dueno = rs.getString("dsnom_dueno");
        dsciudad = rs.getString("dsciudad");
        dsdireccion = rs.getString("dsdireccion");
        nmtelefono = rs.getLong("nmtelefono");
    }
}
