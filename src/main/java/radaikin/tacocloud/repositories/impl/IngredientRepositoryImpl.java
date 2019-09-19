package radaikin.tacocloud.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import radaikin.tacocloud.entities.Ingredient;
import radaikin.tacocloud.entities.Type;
import radaikin.tacocloud.repositories.IngredientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;
    //SQL
    private String findAll =
            "select id, name, type" +
            "from Ingredient";

    //SQL
    private String findOne =
            "select id, name, type" +
            "from Ingredient" +
            "where id=?";

    @Autowired
    public IngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(findAll,this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.queryForObject(findOne,this::mapRowToIngredient, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Type.valueOf(rs.getString("type")));
    }
}
