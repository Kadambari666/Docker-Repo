package Main;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
    }
}

interface Category {
    String getCategoryName();
}

class ElectronicsCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Electronics";
    }
}

class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product laptop = new Product(1, "Laptop", 999.99);
        Product shirt = new Product(2, "Shirt", 29.99);

        ElectronicsCategory electronicsCategory = new ElectronicsCategory();
        ClothingCategory clothingCategory = new ClothingCategory();

        inventory.addProduct(laptop);
        inventory.addProduct(shirt);

        System.out.println("All Products in Inventory:");
        inventory.displayProducts();

        System.out.println("\nProduct Categories:");
        System.out.println("Laptop Category: " + electronicsCategory.getCategoryName());
        System.out.println("Shirt Category: " + clothingCategory.getCategoryName());
    }
}
