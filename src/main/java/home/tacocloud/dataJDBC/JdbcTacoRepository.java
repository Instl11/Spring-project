package home.tacocloud.dataJDBC;

import home.tacocloud.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

//@Repository
//public class JdbcTacoRepository implements TacoRepository {
//
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    public JdbcTacoRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    @Override
//    public Taco save(Taco designedTaco) {
//        long tacoId = saveTacoInfo(designedTaco);
//        designedTaco.setId(tacoId);
//        for (String ing : designedTaco.getIngredients()) {
//            saveIngredientToTaco(ing, tacoId);
//        }
//        return designedTaco;
//    }
//
//    private long saveTacoInfo(Taco taco) {
//        taco.setCreatedAt(new Date());
//        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
//                "INSERT INTO Taco (name, createdAt) VALUES (?,?)",
//                Types.VARCHAR, Types.TIMESTAMP);
//
//        pscf.setReturnGeneratedKeys(true); //разрешаем возврат ген. ключей
//
//        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
//                Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime()))
//        );
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbc.update(psc, keyHolder);
//        List<Map<String, Object>> keyList = keyHolder.getKeyList();
//        int id = (int) keyList.get(0).get("id");
//        return id;
//    }
//
//
//    private void saveIngredientToTaco(String ingredientId, long tacoId) {
//        jdbc.update("INSERT INTO Taco_Ingredients (taco, ingredient) " +
//                        "VALUES (?,?)",
//                tacoId, ingredientId);
//    }
//}
