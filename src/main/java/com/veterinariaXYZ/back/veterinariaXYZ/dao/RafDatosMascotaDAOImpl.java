package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Mascota;
import com.veterinariaXYZ.back.veterinariaXYZ.mapper.RafDatosMascotaMapper;
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

public class RafDatosMascotaDAOImpl implements RafDatosMascotaDAO {

    private static final String INSERT ="INSERT INTO mascota(dsnom_mascota, dsespecie, dsraza, dtf_nacimiento, dsT_identificacion, nmidentificacion, dsnom_dueno, dsciudad, dsdireccion, nmtelefono, dtf_registro) VALUES (?,?,?,NOW(),?,?,?,?,?,?,NOW())";

    private static final String UPDATE = "UPDATE mascota set dsnom_mascota = ?, dsespecie = ?, dsraza = ?, dtf_nacimiento = ?, dsT_identificacion = ?, nmidentificacion = ?, dsnom_dueno = ?, dsciudad = ?, dsdireccion = ?, nmtelefono = ?, dtf_registro = ?  WHERE nmid = ?";

    private static final String SELECT = "SELECT * FROM mascota";

    private static final String SELECTBYID = SELECT + " WHERE nmid = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafDatosMascotaDAOImpl(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override

    public List<Mascota> getAll() { return jdbcTemplate.query(SELECT, new RafDatosMascotaMapper());}

    @Override

    public Mascota getById(int nmid){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new RafDatosMascotaMapper(),nmid);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override

    public Mascota insert(Mascota entity){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmdato" });
            DaoUtil.setPrepareStatement(ps, new Object[]{entity.getDsnom_mascota(), entity.getDsespecie(), entity.getDsraza(), entity.getDtf_nacimiento(), entity.getDsT_identificacion(), entity.getNmidentificacion(), entity.getDsnom_dueno(), entity.getDsciudad(), entity.getDsdireccion(), entity.getNmtelefono(), entity.getDtf_registro()});
            return ps;
        }, keyHolder);
        entity.setNmid(keyHolder.getKey().intValue());
        return entity;
    }

    @Override

    public Mascota update(Mascota entity){
        jdbcTemplate.update(UPDATE, entity.getDsnom_mascota(), entity.getDsespecie(), entity.getDsraza(), entity.getDtf_nacimiento(), entity.getDsT_identificacion(), entity.getNmidentificacion(), entity.getDsnom_dueno(), entity.getDsciudad(), entity.getDsdireccion(), entity.getNmtelefono(), entity.getDtf_registro());
        return entity;
    }



}
