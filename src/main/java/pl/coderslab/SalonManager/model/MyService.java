package pl.coderslab.SalonManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "services")
public class MyService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 5, max = 140, message = "*Your name must have at least 5 and maximum of 140 characters")
    @NotEmpty(message = "*Please provide service name")
    private String name;

    @Min(value = 0, message = "*Please provide a valid number.Number must be greater or equal to 0")
    @Range(min=0, max=1000, message = "*Please provide a valid number.Number must be greater or equal to 0")
    @NotNull(message = "*Please provide a price")
    private int price;

    @NotNull(message = "*Please choose a currency")
    private String currency;

    public MyService(String name, int price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
}
