public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting application...");
        logger2.log("Logging from another class...");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton works!");
        } else {
            System.out.println("Different logger instances exist. Singleton failed!");
        }
    }
}
