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
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nmid;
    private String dsnom_mascota;
    private String dsespecie;
    private String dsraza;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtf_nacimiento;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dtf_registro;
    private long nmidentificacion_dueno;

    public Mascota() {
    }

    public Mascota(int nmid,
                   String dsnom_mascota,
                   String dsespecie,
                   String dsraza,
                   LocalDate dtf_nacimiento,
                   LocalDate dtf_registro,
                    long nmidentificacion_dueno) {
        this.nmid = nmid;
        this.dsnom_mascota = dsnom_mascota;
        this.dsespecie = dsespecie;
        this.dsraza = dsraza;
        this.dtf_nacimiento = dtf_nacimiento;
        this.dtf_registro = dtf_registro;
        this.nmidentificacion_dueno = nmidentificacion_dueno;
    }
    public Mascota(String dsnom_mascota,
                   String dsespecie,
                   String dsraza,
                   LocalDate dtf_nacimiento,
                   LocalDate dtf_registro,
                   long nmidentificacion_dueno){
        this.dsnom_mascota = dsnom_mascota;
        this.dsespecie = dsespecie;
        this.dsraza = dsraza;
        this.dtf_nacimiento = dtf_nacimiento;
        this.dtf_registro = dtf_registro;
        this.nmidentificacion_dueno = nmidentificacion_dueno;
    }

    public int getNmid() {
        return nmid;
    }

    public void setNmid(int nmid) {
        this.nmid = nmid;
    }

    public String getDsnom_mascota() {
        return dsnom_mascota;
    }

    public void setDsnom_mascota(String dsnom_mascota) {
        this.dsnom_mascota = dsnom_mascota;
    }

    public String getDsespecie() {
        return dsespecie;
    }

    public void setDsespecie(String dsespecie) {
        this.dsespecie = dsespecie;
    }

    public String getDsraza() {
        return dsraza;
    }

    public void setDsraza(String dsraza) {
        this.dsraza = dsraza;
    }

    public LocalDate getDtf_nacimiento() {
        return dtf_nacimiento;
    }

    public void setDtf_nacimiento(LocalDate dtf_nacimiento) {
        this.dtf_nacimiento = dtf_nacimiento;
    }

    public LocalDate getDtf_registro() {return dtf_registro;}
    public void setDtf_registro(LocalDate dtf_registro) {this.dtf_registro = dtf_registro;}

    public long getNmidentificacion_dueno() {
        return nmidentificacion_dueno;
    }

    public void setNmidentificacion_dueno(long nmidentificacion_dueno) {this.nmidentificacion_dueno = nmidentificacion_dueno;}
    @JsonIgnore
    public void setDatosMascotaFromRs(ResultSet rs) throws SQLException {
        nmid = rs.getInt("nmid");
        dsnom_mascota = rs.getString("dsnom_mascota");
        dsespecie = rs.getString("dsespecie");
        dsraza = rs.getString("dsraza");
        dtf_nacimiento = UtilDate.getLocalDate(rs.getDate("dtf_nacimiento"));
        dtf_registro = UtilDate.getLocalDate(rs.getDate("dtf_registro"));
        nmidentificacion_dueno = rs.getLong("nmidentificacion_dueno");
    }
}
