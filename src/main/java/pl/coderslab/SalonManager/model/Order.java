package pl.coderslab.SalonManager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 5, max = 50, message = "*Order name must have at least 5 and maximum of 50 characters")
    @NotNull(message = "*Please provide your order name e.g. \"Hair dyeing\"")
    private String name;

    @ManyToOne
    private User orderedBy;

    @NotNull(message = "*Please choose one of the option")
    @ManyToOne
    private User performedBy;

    @NotEmpty(message = "*Please choose at least one of the option")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<MyService> services;

    @NotNull(message = "*Please choose a date")
    @NotBlank(message = "*Please choose a date")
    private String orderCompletionDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Order(String name,
                 User orderedBy,
                 User performedBy,
                 List<MyService> services,
                 String orderCompletionDate,
                 LocalDateTime createdAt,
                 LocalDateTime updatedAt) {
        this.name = name;
        this.orderedBy = orderedBy;
        this.performedBy = performedBy;
        this.services = services;
        this.orderCompletionDate = orderCompletionDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
