import java.util.Scanner;

public class Main {

    public static double forecast(double amount, double rate, int years) {
        if (years == 0) return amount;
        return forecast(amount, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ₹");
        double initialInvestment = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 5 for 5%): ");
        double ratePercent = scanner.nextDouble();
        double growthRate = ratePercent / 100;

        System.out.print("Enter number of years to forecast: ");
        int targetYear = scanner.nextInt();

        double futureValue = forecast(initialInvestment, growthRate, targetYear);

        System.out.printf("Future Value after %d years: ₹%.2f\n", targetYear, futureValue);

        scanner.close();
    }
}
