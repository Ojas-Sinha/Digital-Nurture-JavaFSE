//Exercise 4: Implementing the Adapter Pattern

interface PaymentProcessor {
    void processPayment(double amount);
}

class BhimUPI {

    public void sendMoney(double amount) {
        System.out.println("Paid Rs." + amount + " using BHIM UPI");
    }
}

class PhonePe {

    public void makeTransaction(double amount) {
        System.out.println("Paid Rs." + amount + " using PhonePe");
    }
}

class BhimAdapter implements PaymentProcessor {

    private BhimUPI bhim;

    public BhimAdapter(BhimUPI bhim) {
        this.bhim = bhim;
    }

    public void processPayment(double amount) {
        bhim.sendMoney(amount);
    }
}

class PhonePeAdapter implements PaymentProcessor {

    private PhonePe phonePe;

    public PhonePeAdapter(PhonePe phonePe) {
        this.phonePe = phonePe;
    }

    public void processPayment(double amount) {
        phonePe.makeTransaction(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {

        PaymentProcessor bhim = new BhimAdapter(new BhimUPI());

        PaymentProcessor phonePe = new PhonePeAdapter(new PhonePe());

        bhim.processPayment(800);
        phonePe.processPayment(1000);
    }
}
