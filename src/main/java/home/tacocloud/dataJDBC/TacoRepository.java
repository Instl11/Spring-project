package home.tacocloud.dataJDBC;

import home.tacocloud.Taco;

public interface TacoRepository {

    Taco save(Taco designedTaco);
}
