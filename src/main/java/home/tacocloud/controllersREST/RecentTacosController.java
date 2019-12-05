package home.tacocloud.controllersREST;

import home.tacocloud.Taco;
import home.tacocloud.dataJPA.TacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
public class RecentTacosController {

    private PagedResourcesAssembler pagedResourcesAssembler;

    private TacoRepository repo;

    public RecentTacosController(PagedResourcesAssembler pagedResourcesAssembler, TacoRepository repo) {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
        this.repo = repo;
    }

    @SuppressWarnings("unchecked")
    @GetMapping(path = "/tacos/recent", produces = MediaTypes.HAL_JSON_VALUE)
    @ResponseBody
    public PagedResources<PersistentEntityResource> recentTacos(Pageable pageable, PersistentEntityResourceAssembler resourceAssembler) {

        PageRequest page = PageRequest.of(
                0, 5, Sort.by("createdAt").descending());

        Page<Taco> all = repo.findAll(pageable);

        List<Taco> test = repo.test();



        return pagedResourcesAssembler.toResource(all, resourceAssembler);


//        PageRequest page = PageRequest.of(
//                0, 12, Sort.by("createdAt").descending());
//        List<Taco> tacos = repo.findAll(page).getContent();
//
//
//        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
//        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
//        recentResources.add(
//                linkTo(methodOn(RecentTacosController.class).recentTacos())
//                        .withRel("recents"));
//
//        return recentResources;
    }









/*
    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    @ResponseBody
    public Resources<TacoResource> recentTacos() {

        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = repo.findAll(page).getContent();


        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
        recentResources.add(
                linkTo(methodOn(RecentTacosController.class).recentTacos())
                        .withRel("recents"));

        return recentResources;
    }

 */
}
