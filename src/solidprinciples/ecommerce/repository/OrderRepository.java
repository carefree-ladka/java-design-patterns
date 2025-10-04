package solidprinciples.ecommerce.repository;

import solidprinciples.ecommerce.model.Order;

public interface OrderRepository {
    void save(Order order);
}
