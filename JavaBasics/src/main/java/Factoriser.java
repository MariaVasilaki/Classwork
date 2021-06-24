import java.util.Scanner;

public class Factoriser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give an integer");
        int userInput = sc.nextInt();
        System.out.println("You chose the number: " + userInput);
        int numOfFactors = 0;
        int remainder = userInput;

        for (int i = 1; i <= userInput; i++) {
            if (userInput % i == 0) {
                System.out.print(i + " ");
                numOfFactors++;
                remainder -= i;
            }
        }
        System.out.println();
        System.out.println(userInput + " has " + numOfFactors + " factors");
        if (numOfFactors > 2) {
            System.out.println(userInput + " is not a prime number");
        } else {
            System.out.println(userInput + " is a prime number");
        }


        if (remainder == 0) {
            System.out.println(userInput + " is a perfect number");
        } else {
            System.out.println(userInput + " is not a perfect number");
        }



    }

}
