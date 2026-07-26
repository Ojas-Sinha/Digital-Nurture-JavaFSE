//Exercise 2: E-commerce Platform Search Function
/*
Big O notation measures how the execution time of an algorithm grows as the input size (n) increases.
Linear Search
Best Case: O(1) (Element found at first position.)
Average Case: O(n)
Worst Case: O(n) (Element found at last position or not present.)

Binary Search

Best Case: O(1) (Middle element is the target.)
Average Case: O(log n)
Worst Case: O(log n) 

Binary Search is more suitable for an e-commerce platform because it perform faster searching for large product catalogs.*/

import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productId + " " + productName + " " + category;
    }
}

public class ECommerceSearchFunction {

    public static Product linearSearch(Product[] products, String target) {
        for(Product p : products) {
            if(p.productName.equalsIgnoreCase(target))
                return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {

        int low = 0, high = products.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            int cmp = products[mid].productName.compareToIgnoreCase(target);

            if(cmp == 0)
                return products[mid];
            else if(cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Monitor", "Electronics")
        };

        Product result1 = linearSearch(products, "Mouse");
        System.out.println("Linear Search: " + result1);

        Arrays.sort(products,
            Comparator.comparing(p -> p.productName));

        Product result2 = binarySearch(products, "Mouse");
        System.out.println("Binary Search: " + result2);
    }
}