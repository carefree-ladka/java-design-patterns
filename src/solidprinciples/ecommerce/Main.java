package solidprinciples.ecommerce;

import solidprinciples.ecommerce.model.Order;
import solidprinciples.ecommerce.model.Product;
import solidprinciples.ecommerce.payment.CreditCardPayment;
import solidprinciples.ecommerce.payment.PaymentMethod;
import solidprinciples.ecommerce.repository.InMemoryOrderRepository;
import solidprinciples.ecommerce.repository.OrderRepository;
import solidprinciples.ecommerce.service.OrderService;

import java.util.List;

public class Main {

    void main() {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        List<Product> products = List.of(
                new Product("Laptop", 1200),
                new Product("Mouse", 50)
        );

        Order order = new Order(products);

        PaymentMethod paymentMethod = new CreditCardPayment();
        orderService.checkout(order, paymentMethod);
    }
}
