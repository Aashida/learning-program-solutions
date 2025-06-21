// Exercise2.java

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productName + " (" + category + ")";
    }
}

public class Exercise2 {

    // Linear Search Implementation
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search Implementation (on sorted list)
    public static Product binarySearch(List<Product> products, String targetName) {
        int low = 0;
        int high = products.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midName = products.get(mid).productName.toLowerCase();

            if (midName.equals(targetName.toLowerCase())) {
                return products.get(mid);
            } else if (midName.compareTo(targetName.toLowerCase()) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Shampoo", "Personal Care"));
        products.add(new Product(3, "Sneakers", "Footwear"));
        products.add(new Product(4, "Notebook", "Stationery"));
        products.add(new Product(5, "Phone", "Electronics"));

        System.out.println("🔍 Linear Search:");
        Product foundLinear = linearSearch(products, "Sneakers");
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not found"));

        
        products.sort(Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n🔍 Binary Search (on sorted list):");
        Product foundBinary = binarySearch(products, "Sneakers");
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not found"));
    }
}