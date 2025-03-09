import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name, category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("Shirt", "Clothing", 50),
            new Product("Jeans", "Clothing", 70)
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        Map<String, Product> mostExpensiveByCategory = products.stream()
            .collect(Collectors.toMap(p -> p.category, p -> p, 
                (p1, p2) -> p1.price > p2.price ? p1 : p2));

        double averagePrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0);

        groupedByCategory.forEach((category, list) -> {
            System.out.println(category + ": " + list.size() + " products");
        });

        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println("Most expensive in " + category + ": " + product.name);
        });

        System.out.println("Average Price: " + averagePrice);
    }
}
