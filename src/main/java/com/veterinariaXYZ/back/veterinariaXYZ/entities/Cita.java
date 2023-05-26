package com.veterinariaXYZ.back.veterinariaXYZ.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.veterinariaXYZ.back.veterinariaXYZ.util.UtilDate;
import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Entity
@Table
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nmid;
    private long nmidentificacion_dueno;
    private String dsnom_mascota;
    private long nmid_vet;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtf_cita;
    private String hr_cita;
    public Cita() {
    }
    public Cita(int nmid,
                long nmidentificacion_dueno,
                   String dsnom_mascota,
                   long nmid_vet,
                   LocalDate dtf_cita,
                   String hr_cita) {
        this.nmid = nmid;
        this.nmidentificacion_dueno = nmidentificacion_dueno;
        this.dsnom_mascota = dsnom_mascota;
        this.nmid_vet = nmid_vet;
        this.dtf_cita = dtf_cita;
        this.hr_cita = hr_cita;
    }
    public Cita(int nmidentificacion_dueno ,
                    String dsnom_mascota,
                    Long nmid_vet,
                   LocalDate dtf_cita,
                   String hr_cita){
        this.nmidentificacion_dueno = nmidentificacion_dueno;
        this.dsnom_mascota = dsnom_mascota;
        this.nmid_vet = nmid_vet;
        this.dtf_cita = dtf_cita;
        this.hr_cita = hr_cita;
    }

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public long getNmidentificacion_dueno() {
        return nmidentificacion_dueno;
    }

    public void setNmidentificacion_dueno(long nmidentificacion_dueno) {this.nmidentificacion_dueno = nmidentificacion_dueno;}
    public String getDsnom_mascota() {return dsnom_mascota;}

    public void setDsnom_mascota(String dsnom_mascota) {this.dsnom_mascota = dsnom_mascota;}

    public long getNmid_vet() {
        return nmid_vet;
    }

    public void setNmid_vet(long nmid_vet) {
        this.nmid_vet = nmid_vet;
    }

    public LocalDate getDtf_cita() {
        return dtf_cita;
    }

    public void setDtf_cita(LocalDate dtf_cita) {
        this.dtf_cita = dtf_cita;
    }

    public String getHr_cita() {
        return hr_cita;
    }

    public void setHr_cita(String hr_cita) {this.hr_cita = hr_cita;}

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
