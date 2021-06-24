import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you want to invest?");
        double investment = sc.nextDouble();
        System.out.println("How many years are investing?");
        int years = sc.nextInt();
        System.out.println("What is the annual interest rate % growth?");
        double annualRate = sc.nextDouble();
        double quarterlyRate = annualRate/4;
        double currentBalance = investment;
        double earned = 0;

        for ( int i = 1; i <= years; i++) {
            System.out.println("Year " + i + ":");
            System.out.println("Began with $" + currentBalance);
            earned = 3* (currentBalance * (1 + (quarterlyRate / 100)));
            System.out.println("Earned $" + earned);

            System.out.println("Ended with $" + (currentBalance + earned));
            currentBalance = currentBalance + earned;

        }
    }
}
