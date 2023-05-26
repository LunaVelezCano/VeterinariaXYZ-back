package com.veterinariaXYZ.back.veterinariaXYZ.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table
public class Dueno {
    @Id
    @Column(name = "nmidentificacion", nullable = false)
    private long nmidentificacion;
    private String dsT_identificacion;
    private String dsnom_dueno;
    private String dsciudad;
    private String dsdireccion;
    private long nmtelefono;

    public Dueno() {
    }
    public Dueno(long nmidentificacion,
                 String dsT_identificacion,
                 String dsnom_dueno,
                 String dsciudad,
                 String dsdireccion,
                 long nmtelefono){
        this.nmidentificacion = nmidentificacion;
        this.dsT_identificacion = dsT_identificacion;
        this.dsnom_dueno = dsnom_dueno;
        this.dsciudad = dsciudad;
        this.dsdireccion = dsdireccion;
        this.nmtelefono = nmtelefono;
    }
    public Dueno(String dsT_identificacion,
                 String dsnom_dueno,
                 String dsciudad,
                 String dsdireccion,
                 long nmtelefono) {

        this.dsT_identificacion = dsT_identificacion;
        this.nmidentificacion = nmidentificacion;
        this.dsnom_dueno = dsnom_dueno;
        this.dsciudad = dsciudad;
        this.dsdireccion = dsdireccion;
        this.nmtelefono = nmtelefono;
        }

    public long getNmidentificacion() {
        return nmidentificacion;
    }

    public void setNmidentificacion(long nmidentificacion) {
        this.nmidentificacion = nmidentificacion;
    }

    public String getDsT_identificacion() {
        return dsT_identificacion;
    }

    public void setDsT_identificacion(String dsT_identificacion) {
        this.dsT_identificacion = dsT_identificacion;
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
    public long getNmtelefono() {
        return nmtelefono;
    }

    public void setNmtelefono(long nmtelefono) {
        this.nmtelefono = nmtelefono;
    }

    @JsonIgnore
    public void setDatosDuenoFromRs(ResultSet rs) throws SQLException {
        dsT_identificacion = rs.getString("dsT_identificacion");
        nmidentificacion = rs.getLong("nmidentificacion");
        dsnom_dueno = rs.getString("dsnom_dueno");
        dsciudad = rs.getString("dsciudad");
        dsdireccion = rs.getString("dsdireccion");
        nmtelefono = rs.getLong("nmtelefono");

    }
}

