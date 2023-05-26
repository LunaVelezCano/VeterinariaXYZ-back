package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;
import com.veterinariaXYZ.back.veterinariaXYZ.mapper.RafDatosDuenoMapper;
import com.veterinariaXYZ.back.veterinariaXYZ.util.DaoUtil;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RafDatosDuenoDAOImpl implements RafDatosDuenoDAO{

    private static final String INSERT ="INSERT " +
            "INTO dueno(" +
            "nmidentificacion, " +
            "dsT_identificacion, " +
            "dsnom_dueno, " +
            "dsciudad, " +
            "dsdireccion, " +
            "nmtelefono)" +
            "VALUES (?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE dueno set  dsT_identificacion = ?, dsnom_dueno = ?, dsciudad = ?, dsdireccion = ?, nmtelefono = ? nmidentificacion = ? ";
    private static final String SELECT = "SELECT * FROM dueno";

    private static final String SELECTBYID = SELECT + " WHERE nmidentificacion = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafDatosDuenoDAOImpl(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Dueno> getAll() { return jdbcTemplate.query(SELECT, new RafDatosDuenoMapper());}

    @Override
    public Dueno getById(long nmidentificacion){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new RafDatosDuenoMapper(),nmidentificacion);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Dueno insert(Dueno entity){
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmdato" });
            DaoUtil.setPrepareStatement(ps, new Object[]{ entity.getNmidentificacion(), entity.getDsT_identificacion(), entity.getDsnom_dueno(), entity.getDsciudad(), entity.getDsdireccion(), entity.getNmtelefono()});
            return ps;
        });
        return entity;
    }

    @Override

    public Dueno update(Dueno entity){
        jdbcTemplate.update(UPDATE,  entity.getNmidentificacion(), entity.getDsT_identificacion(), entity.getDsnom_dueno(), entity.getDsciudad(), entity.getDsdireccion(), entity.getNmtelefono());
        return entity;
    }


}
