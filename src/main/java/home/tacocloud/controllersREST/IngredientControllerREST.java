package home.tacocloud.controllersREST;

import home.tacocloud.Ingredient;
import home.tacocloud.dataJPA.IngredientRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequestMapping(path = "api/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientControllerREST {

    private IngredientRepository repo;

    public IngredientControllerREST(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    @ResponseBody
    public Iterable<Ingredient> getIngredients() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Ingredient getIngredient(@PathVariable String id) {
        return repo.findById(id).get();
    }
}
