
/* 
In a warehouse inventory system, thousands of products may be stored. Efficient data structures and algorithms 
store large amounts of product data efficiently and perform fast searching, insertion, updating, and deletion. 

Suitable Data Structures are : ArrayList, HashMap, TreeMap
But best choice is HashMap because products can be accessed quickly using their productId.
*/

import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String displayProduct() {
        return "ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: " + price;
    }
}

public class InventoryManagementSystem {
    
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Product Added");
    }

    public void updateProduct(int id, int quantity, double price) {
        if(inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product Updated");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void deleteProduct(int id) {
        if(inventory.remove(id) != null)
            System.out.println("Product Deleted");
        else
            System.out.println("Product Not Found");
    }

    public void displayProducts() {
        for(Product p : inventory.values()) {
            System.out.println(p.displayProduct());
        }
    }

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product(101, "Laptop", 10, 60000));
        ims.addProduct(new Product(102, "Mouse", 50, 500));

        ims.displayProducts();

        ims.updateProduct(101, 15, 57000);

        ims.deleteProduct(102);

        System.out.println("\nUpdated Inventory:");
        ims.displayProducts();
    }
}
