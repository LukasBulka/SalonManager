package pl.coderslab.SalonManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

    private String name;
    private String price;
    private String currency;

    public MyService(String name, String price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
}
