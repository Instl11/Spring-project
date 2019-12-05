package home.tacocloud;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;





@Data
@Entity
//@RestResource(rel = "tacos", path = "tacos")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Should be not null")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @CreationTimestamp
    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    @JoinColumn
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
