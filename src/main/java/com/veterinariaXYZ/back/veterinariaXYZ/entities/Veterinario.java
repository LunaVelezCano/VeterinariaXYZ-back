package com.veterinariaXYZ.back.veterinariaXYZ.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table
public class Veterinario {

    @Id
    @Column(name = "nmidenti_vet", nullable = false)
    private long nmidenti_vet;

    private String dsnom_vet;
    private long nmtelefono;

    public Veterinario() {
    }
    public Veterinario(long nmidenti_vet,
                 String dsnom_vet,
                 long nmtelefono){
        this.nmidenti_vet = nmidenti_vet;
        this.dsnom_vet = dsnom_vet;
        this.nmtelefono = nmtelefono;
    }
    public Veterinario(String dsnom_vet,
                 long nmtelefono) {
        this.nmidenti_vet = nmidenti_vet;
        this.dsnom_vet = dsnom_vet;
        this.nmtelefono = nmtelefono;
    }

    public long getNmidenti_vet() {
        return nmidenti_vet;
    }

    public void setNmidenti_vet(long nmidenti_vet) {
        this.nmidenti_vet = nmidenti_vet;
    }

    public String getDsnom_vet() {
        return dsnom_vet;
    }

    public void setDsnom_vet(String dsnom_vet) {
        this.dsnom_vet = dsnom_vet;
    }

    public long getNmtelefono() {
        return nmtelefono;
    }

    public void setNmtelefono(long nmtelefono) {
        this.nmtelefono = nmtelefono;
    }

    @JsonIgnore
    public void setDatosVetFromRs(ResultSet rs) throws SQLException {
        nmidenti_vet = rs.getLong("nmidenti_vet");
        dsnom_vet = rs.getString("dsnom_vet");
        nmtelefono = rs.getLong("nmtelefono");

    }
}
