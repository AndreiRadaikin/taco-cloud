package radaikin.tacocloud.entities;

import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<String> ingredients;
}
