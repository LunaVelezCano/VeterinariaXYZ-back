package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;
import com.veterinariaXYZ.back.veterinariaXYZ.mapper.RafDatosCitaMapper;
import com.veterinariaXYZ.back.veterinariaXYZ.util.DaoUtil;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RafDatosCitaDAOImpl implements RafDatosCitaDAO {

    private static final String INSERT = "INSERT " +
            "INTO Cita(" +
            "nmidentificacion_dueno, " +
            "dsnom_mascota, " +
            "nmid_vet, " +
            "dtf_cita, " +
            "hr_cita) " +
            "VALUES (?,?,?,?,?)";

    private static final String UPDATE = "UPDATE Cita set nmidentificacion_dueno = ?, dsnom_mascota = ?, nmid_vet = ?, dtf_cita = ?, hr_cita = ? WHERE nmid = ?";

    private static final String DELETE = "DELETE FROM cita WHERE nmid = ?";
    private static final String SELECT = "SELECT * FROM Cita";

    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    private static final String SELECTBYIDENTIFICACIONDUENO = SELECT + " WHERE nmidentificacion_dueno = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafDatosCitaDAOImpl(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override

    public List<Cita> getAll() { return jdbcTemplate.query(SELECT, new RafDatosCitaMapper());}

    @Override

    public Cita getById(int nmid){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new RafDatosCitaMapper(),nmid);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override

    public List<Cita> getByidentificacionDueno(long nmidentificacion_dueno){
        try{
            return jdbcTemplate.query(SELECTBYIDENTIFICACIONDUENO, new RafDatosCitaMapper(),nmidentificacion_dueno);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Cita insert(Cita entity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmdato" });
            DaoUtil.setPrepareStatement(ps, new Object[]{entity.getNmidentificacion_dueno(),entity.getDsnom_mascota(), entity.getNmid_vet(), entity.getDtf_cita(), entity.getHr_cita() });
            return ps;
        }, keyHolder);
        entity.setNmid(keyHolder.getKey().intValue());
        return entity;
    }

    @Override
    public Cita update(Cita entity){
        jdbcTemplate.update(UPDATE, entity.getNmid(), entity.getNmidentificacion_dueno(), entity.getDsnom_mascota(), entity.getNmid_vet(), entity.getDtf_cita(), entity.getHr_cita());
        return entity;
    }
    @Override
    public Cita delete(Cita entity){
        jdbcTemplate.update(DELETE, entity.getNmid());
        return entity;
    }
}


