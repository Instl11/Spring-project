package home.tacocloud;

import home.tacocloud.controllersREST.IngredientControllerREST;
import org.springframework.data.rest.webmvc.EmbeddedResourcesAssembler;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class IngredientResourceAssembler
        extends ResourceAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientControllerREST.class, IngredientResource.class);
    }

    @Override
    protected IngredientResource instantiateResource(Ingredient entity) {
        return new IngredientResource(entity);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(), ingredient);
    }
}
