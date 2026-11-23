package mylab.order.di.xml;

public class Product {
    private String id;
    private String name;
    private double price;
    
    public Product() {}
    
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

package mylab.order.di.xml;

import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    
    public ShoppingCart() {}
    
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    
    public double getTotalPrice() {
    	double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
        //return products.stream().mapToDouble(Product::getPrice).sum();
    }
    
    @Override
    public String toString() {
        return "ShoppingCart [products=" + products + "]";
    }
}

package mylab.order.di.xml;
public class OrderService {
    private ShoppingCart shoppingCart;
    
    public OrderService() {}
    
    public ShoppingCart getShoppingCart() { 
    	return shoppingCart; 
    }
    
    public void setShoppingCart(ShoppingCart shoppingCart) { 
    	this.shoppingCart = shoppingCart; 
    }
    
    public double calculateOrderTotal() {
        return shoppingCart.getTotalPrice();
    }
    
    @Override
    public String toString() {
        return "OrderService [shoppingCart=" + shoppingCart + "]";
    }
}