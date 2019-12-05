package home.tacocloud;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoResource extends ResourceSupport {

    private static final IngredientResourceAssembler ingredientAssembler =
            new IngredientResourceAssembler();

    @Getter
    private String name;

    @Getter
    private Date createdAt;

    @Getter
    private List<IngredientResource> ingredients;

    public TacoResource() {
    }

    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toResources(taco.getIngredients());
    }
}
