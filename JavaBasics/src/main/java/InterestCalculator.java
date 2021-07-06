import java.math.BigDecimal;
import java.util.Scanner;
import java.util.*;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you want to invest?");
        BigDecimal investment = sc.nextBigDecimal();
        System.out.println("How many years are investing?");
        int years = sc.nextInt();
        System.out.println("What is the annual interest rate % growth?");
        BigDecimal annualRate = sc.nextBigDecimal();
        BigDecimal quarterlyRate = annualRate.divide(BigDecimal.valueOf(4));
        BigDecimal currentBalance = investment;
        BigDecimal earned;

        for ( int i = 1; i <= years; i++) {
            System.out.println("Year " + i + ":");
            System.out.println("Began with $" + currentBalance);
            earned = BigDecimal.valueOf(3).multiply((currentBalance.multiply(BigDecimal.valueOf(1).add(quarterlyRate.divide(BigDecimal.valueOf(100))))));
            System.out.println("Earned $" + earned);

            System.out.println("Ended with $" + (currentBalance.add(earned)));
            currentBalance = currentBalance.add(earned);

        }
    }
}
