package solidprinciples.ecommerce.service;

import solidprinciples.ecommerce.model.Order;
import solidprinciples.ecommerce.payment.PaymentMethod;
import solidprinciples.ecommerce.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void checkout(Order order, PaymentMethod paymentMethod) {
        paymentMethod.pay(order.totalPrice());
        orderRepository.save(order);
    }
}
