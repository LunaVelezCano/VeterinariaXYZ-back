package com.veterinariaXYZ.back.veterinariaXYZ.dao;

import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;
import com.veterinariaXYZ.back.veterinariaXYZ.mapper.RafDatosVetMapper;
import com.veterinariaXYZ.back.veterinariaXYZ.util.DaoUtil;
import org.springframework.cache.CacheManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RafDatosVetDAOImpl implements RafDatosVetDAO {

    private static final String INSERT ="INSERT " +
            "INTO veterinario(" +
            "nmidenti_vet, " +
            "dsnom_vet, " +
            "nmtelefono)" +
            "VALUES (?,?,?)";

    private static final String UPDATE = "UPDATE veterinario set  dsnom_vet = ?, nmtelefono = ? nmidenti_vet = ? ";

    private static final String SELECT = "SELECT * FROM veterinario";

    private static final String SELECTBYID = SELECT + " WHERE nmidenti_vet = ?";

    JdbcTemplate jdbcTemplate;
    private CacheManager cacheManager;

    public RafDatosVetDAOImpl(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Veterinario> getAll() { return jdbcTemplate.query(SELECT, new RafDatosVetMapper());}

    @Override
    public Veterinario getById(long nmidenti_vet){
        try{
            return jdbcTemplate.queryForObject(SELECTBYID, new RafDatosVetMapper(),nmidenti_vet);
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Veterinario insert(Veterinario entity){
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT, new String[]{ "nmdato" });
            DaoUtil.setPrepareStatement(ps, new Object[]{ entity.getNmidenti_vet(), entity.getDsnom_vet(), entity.getNmtelefono()});
            return ps;
        });
        return entity;
    }

    @Override
    public Veterinario update(Veterinario entity){
        jdbcTemplate.update(UPDATE,  entity.getNmidenti_vet(), entity.getDsnom_vet(), entity.getNmtelefono());
        return entity;
    }

}
