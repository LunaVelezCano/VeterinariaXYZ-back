package com.veterinariaXYZ.back.veterinariaXYZ.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.veterinariaXYZ.back.veterinariaXYZ.util.UtilDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
@EqualsAndHashCode()

public class DatosMascota implements Serializable {

    private static final long serialVersionUID = 1L;

    private int nmid;
    private String dsnom_mascota;
    private String dsespecie;
    private String dsraza;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtf_nacimiento;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtf_registro;
    private  long nmidentificacion_dueno;

    @JsonIgnore
    public void setDatosMascotaFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnom_mascota = rs.getString("dsnom_mascota");
        dsespecie = rs.getString("dsespecie");
        dsraza = rs.getString("dsraza");
        dtf_nacimiento= UtilDate.getLocalDate(rs.getDate("dtf_nacimiento"));
        dtf_registro = UtilDate.getLocalDate(rs.getDate("dtf_registro"));
        nmidentificacion_dueno = rs.getLong("nmidentificacion_dueno");
    }
}



