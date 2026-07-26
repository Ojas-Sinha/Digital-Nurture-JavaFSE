//Exercise 3: Sorting Customer Orders
 
class Order {

    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderId + " " + customerName + " Rs." + totalPrice;
    }
}
public class CustomerOrderSorting {
    
    static void bubbleSort(Order[] orders) {

        for(int i = 0; i < orders.length; i++) {
            for(int j = 0; j < orders.length - i - 1; j++) {
                
                if(orders[j].totalPrice > orders[j+1].totalPrice) {
                    
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;

                }
            }
        }
    }

    static void quickSort(Order[] orders, int low, int high) {

        if(low < high) {
            int p = partition(orders, low, high);

            quickSort(orders, low, p);
            quickSort(orders, p + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[low].totalPrice;
        int i = low - 1, j = high + 1;

        while(true) {

            do{ i++; }while(orders[i].totalPrice < pivot);
            do{ j--; }while(orders[j].totalPrice > pivot);

            if(i >= j) return j;

            Order temp = orders[i];
            orders[i] = orders[j];
            orders[j] = temp;
        }
    }

    static void display(Order[] orders){

        for(Order order: orders)
            System.out.println(order);
        
        System.out.println();
    }

    public static void main(String[] args) {

        Order[] orders = {

            new Order(101, "Rahul", 2500),
            new Order(102, "Amit", 1500),
            new Order(103, "Priya", 7000),
            new Order(104, "Sneha", 4000)
        };

        System.out.println("Original Orders");
        display(orders);

        bubbleSort(orders);

        System.out.println("After Bubble Sort");
        display(orders);

        Order[] orders2 = {

            new Order(101, "Rahul", 2500),
            new Order(102, "Amit", 1500),
            new Order(103, "Priya", 7000),
            new Order(104, "Sneha", 4000)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("After Quick Sort");
        display(orders2);
    }
}
