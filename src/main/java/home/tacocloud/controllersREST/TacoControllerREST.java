package home.tacocloud.controllersREST;

import home.tacocloud.Taco;
import home.tacocloud.dataJPA.TacoRepository;
import home.tacocloud.users.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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


