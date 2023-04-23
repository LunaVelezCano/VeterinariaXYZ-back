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

    public Mascota() {
    }

    public Mascota(int nmid,
                   String dsnom_mascota,
                   String dsespecie,
                   String dsraza,
                   LocalDate dtf_nacimiento,
                   String dsT_identificacion,
                   int nmidentificacion,
                   String dsnom_dueno,
                   String dsciudad,
                   String dsdireccion,
                   int nmtelefono,
                   LocalDate dtf_registro) {
        this.nmid = nmid;
        this.dsnom_mascota = dsnom_mascota;
        this.dsespecie = dsespecie;
        this.dsraza = dsraza;
        this.dtf_nacimiento = dtf_nacimiento;
        this.dsT_identificacion = dsT_identificacion;
        this.nmidentificacion = nmidentificacion;
        this.dsnom_dueno = dsnom_dueno;
        this.dsciudad = dsciudad;
        this.dsdireccion = dsdireccion;
        this.nmtelefono = nmtelefono;
        this.dtf_registro = dtf_registro;
    }

    public Mascota(String dsnom_mascota,
                   String dsespecie,
                   String dsraza,
                   LocalDate dtf_nacimiento,
                   String dsT_identificacion,
                   int nmidentificacion,
                   String dsnom_dueno,
                   String dsciudad,
                   String dsdireccion,
                   int nmtelefono,
                   LocalDate dtf_registro) {
        this.nmid = nmid;
        this.dsnom_mascota = dsnom_mascota;
        this.dsespecie = dsespecie;
        this.dsraza = dsraza;
        this.dtf_nacimiento = dtf_nacimiento;
        this.dsT_identificacion = dsT_identificacion;
        this.nmidentificacion = nmidentificacion;
        this.dsnom_dueno = dsnom_dueno;
        this.dsciudad = dsciudad;
        this.dsdireccion = dsdireccion;
        this.nmtelefono = nmtelefono;
        this.dtf_registro = dtf_registro;
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

    public String getDsT_identificacion() {
        return dsT_identificacion;
    }

    public void setDsT_identificacion(String dsT_identificacion) {
        this.dsT_identificacion = dsT_identificacion;
    }

    public int getNmidentificacion() {
        return nmidentificacion;
    }

    public void setNmidentificacion(int nmidentificacion) {
        this.nmidentificacion = nmidentificacion;
    }

    public String getDsnom_dueno() {
        return dsnom_dueno;
    }

    public void setDsnom_dueno(String dsnom_dueno) {
        this.dsnom_dueno = dsnom_dueno;
    }

    public String getDsciudad() {
        return dsciudad;
    }

    public void setDsciudad(String dsciudad) {
        this.dsciudad = dsciudad;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }

    public int getNmtelefono() {
        return nmtelefono;
    }

    public void setNmtelefono(int nmtelefono) {
        this.nmtelefono = nmtelefono;
    }

    public LocalDate getDtf_registro() {
        return dtf_registro;
    }

    public void setDtf_registro(LocalDate dtf_registro) {
        this.dtf_registro = dtf_registro;
    }

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