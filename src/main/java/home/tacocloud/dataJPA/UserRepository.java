package home.tacocloud.dataJPA;

import home.tacocloud.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername (String username);
}
