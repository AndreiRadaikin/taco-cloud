package radaikin.tacocloud.entities;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;
    private Date CreatedAt;
    @NotNull
    @Size(min = 5, message = "Must be at least 5 characters long")
    private String name;
    @Size(min = 1, message = "You mast choose at least 1 ingredient")
    private List<String> ingredients;
}
