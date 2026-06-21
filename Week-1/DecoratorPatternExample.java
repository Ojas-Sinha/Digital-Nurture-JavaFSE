// Exercise 5: Implementing the Decorator Pattern

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {

    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {

    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        
        Notifier SMSNotifier = new SMSNotifierDecorator(new EmailNotifier());

        SMSNotifier.send("Server Down!");

        Notifier SlackNotifier = new SlackNotifierDecorator(new EmailNotifier());

        SlackNotifier.send("Server Down!");
    }
}