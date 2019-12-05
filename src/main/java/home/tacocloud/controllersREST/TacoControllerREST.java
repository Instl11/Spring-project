package home.tacocloud.controllersREST;

import home.tacocloud.Taco;
import home.tacocloud.dataJPA.TacoRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RepositoryRestController
@RequestMapping(path = "api/tacos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TacoControllerREST {



//    private TacoRepository repo;
//
//    public TacoControllerREST(TacoRepository repo) {
//        this.repo = repo;
//    }
//
//    @GetMapping("/id")
//    public Taco getTaco(@PathVariable Long id){
//        return repo.findById(id).get();
//    }


}

