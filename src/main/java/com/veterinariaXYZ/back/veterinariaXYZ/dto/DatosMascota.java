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
    private String dsT_identificacion;
    private int nmidentificacion;
    private String dsnom_dueno;
    private String dsciudad;
    private String dsdireccion;
    private int nmtelefono;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dtf_registro;

    @JsonIgnore
    public void setDatosMascotaFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnom_mascota = rs.getString("dsnom_mascota");
        dsespecie = rs.getString("dsespecie");
        dsraza = rs.getString("dsraza");
        dtf_nacimiento= UtilDate.getLocalDate(rs.getDate("dtf_nacimiento"));
        dsT_identificacion = rs.getString("dsT_identificacion");
        nmidentificacion = rs.getInt("nmidentificacion");
        dsnom_dueno = rs.getString("dsnom_dueno");
        dsciudad = rs.getString("dsciudad");
        dsdireccion = rs.getString("dsdireccion");
        nmtelefono = rs.getInt("nmtelefono");
        dtf_registro = UtilDate.getLocalDate(rs.getDate("dtf_registro"));
    }
}



