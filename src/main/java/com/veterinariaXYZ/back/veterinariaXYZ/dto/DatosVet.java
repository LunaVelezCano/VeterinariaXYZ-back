package com.veterinariaXYZ.back.veterinariaXYZ.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@EqualsAndHashCode()

public class DatosVet implements Serializable {
    private static final long serialVersionUID = 1L;

    private long nmidenti_vet;
    private String dsnom_vet;
    private long nmtelefono;

    @JsonIgnore
    public void setDatosMascotaFromRs(ResultSet rs) throws SQLException {
        nmidenti_vet = rs.getLong("nmidenti_vet");
        dsnom_vet = rs.getString("dsnom_vet");
        nmtelefono = rs.getLong("nmtelefono");
    }
}
