package home.tacocloud.dataJDBC;

import com.fasterxml.jackson.databind.ObjectMapper;
import home.tacocloud.Order;
import home.tacocloud.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class JdbcOrderRepository implements OrderRepository {

    SimpleJdbcInsert orderInserter;
    SimpleJdbcInsert orderTacoInserter;
    ObjectMapper mapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.mapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        long orderId = saveOrderToTacoOrder(order);
        order.setId(orderId);
        List<Taco> tacoList = order.getTacoList();
        for (Taco t : tacoList){
            saveTacoToTacoOrderTacos(t, orderId);
        }
        return order;
    }

    private long saveOrderToTacoOrder(Order order){
        order.setCreatedAt(new Date());
        Map<String, Object> values = mapper.convertValue(order, Map.class);
        values.put("createdAt", order.getCreatedAt());
        int orderId = orderInserter.executeAndReturnKey(values).intValue();
        return orderId;
    }

    private void saveTacoToTacoOrderTacos(Taco taco, long orderId){
        HashMap<String, Object> values = new HashMap<>();
        values.put("tacoorder", orderId);
        values.put("taco", taco.getId());
        orderTacoInserter.execute(values);
    }
}
