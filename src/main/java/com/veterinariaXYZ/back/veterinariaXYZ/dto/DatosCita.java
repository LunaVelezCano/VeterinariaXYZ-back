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
public class DatosCita implements Serializable {

    private static final long serialVersionUID = 1L;

    private int nmid;

    private long nmidentificacion_dueno;

    private String dsnom_mascota;

    private long nmid_vet;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtf_cita;

    private String hr_cita;

    @JsonIgnore
    public void setDatosCitaFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        nmidentificacion_dueno = rs.getInt("nmidentificacion_dueno");
        dsnom_mascota = rs.getString("dsnom_mascota");
        nmid_vet = rs.getLong("nmid_vet");
        dtf_cita = UtilDate.getLocalDate(rs.getDate("dtf_cita"));
        hr_cita = rs.getString("hr_cita");

        }
    }

