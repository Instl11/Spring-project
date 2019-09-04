package home.tacocloud.dataJDBC;

import home.tacocloud.Order;

public interface OrderRepository {

    Order save(Order order);
}
