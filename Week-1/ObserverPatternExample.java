//Exercise 7: Implementing the Observer Pattern

import java.util.*;

interface Observer {
    void update(String stockName, double price);
}

interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }
}

class MobileApp implements Observer {

    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName +" updated to Rs." + price);
    }
}

class WebApp implements Observer {

    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName +" updated to Rs." + price);
    }
}

public class ObserverPatternExample {
    
    public static void main(String[] args) {

        StockMarket market = new StockMarket();

        market.register(new MobileApp());
        market.register(new WebApp());

        market.setStockPrice("TCS", 4200);
        market.setStockPrice("Infosys", 1800);
    }
}
