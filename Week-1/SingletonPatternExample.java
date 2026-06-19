//Exercise 1: Implementing the Singleton Pattern

//Logger class
class Logger {
    private static Logger instance;

    //Logger constructor
    private Logger(){
        System.out.println("Logger Instance Created");
    }

    public static Logger getInstance() {

        //Double-Checked Locking
        if(instance == null) {
            synchronized(Logger.class) {
                if(instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    //method to print log message
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        System.out.println(logger1 == logger2);
    }
}