import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int rolls = 0;
        double maxAmount = 0;
        int rollsByThen = 0;
        System.out.println("How many dollars would you like to bet?");
        double userInput = sc.nextDouble();
        while (userInput > 0) {
            rolls += 1;
            int die1 = r.nextInt(7);
            //System.out.println(die1);
            int die2 = r.nextInt(7);
            if (die1 + die2 == 7) {
                userInput += 4;
                maxAmount = userInput;
                rollsByThen = rolls;
            } else {
                userInput -= 1;
            }

        }
        System.out.println("You were broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + rollsByThen + " rolls when you had $" + maxAmount + ".");



    }
}


