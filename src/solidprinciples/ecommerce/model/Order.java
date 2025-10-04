package solidprinciples.ecommerce.model;

import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double totalPrice() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
