package home.tacocloud.dataJPA;

import home.tacocloud.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tacos", path = "tacos")
public interface TacoRepository extends JpaRepository<Taco, Long> {

    @Query(value = "select distinct t from Taco t " +
                   "right join t.ingredients")
    List<Taco> test();

}
