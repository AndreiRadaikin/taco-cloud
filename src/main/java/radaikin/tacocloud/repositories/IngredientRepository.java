package radaikin.tacocloud.repositories;

import org.springframework.stereotype.Repository;
import radaikin.tacocloud.entities.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);

}
