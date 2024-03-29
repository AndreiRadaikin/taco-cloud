package radaikin.tacocloud.entities;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class Order {

    private Long id;
    private Date createdAt;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "zip is required")
    private String zip;
    @CreditCardNumber(message = "not valid cc number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]| 1[0-2]) ([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}
