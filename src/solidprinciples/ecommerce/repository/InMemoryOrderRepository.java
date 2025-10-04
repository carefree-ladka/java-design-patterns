package solidprinciples.ecommerce.repository;

import solidprinciples.ecommerce.model.Order;

public class InMemoryOrderRepository implements OrderRepository {
    @Override
    public void save(Order order) {
        IO.println("Order saved in memory: " + order.getProducts().size() + " products");
    }
}
