package ui;

import java.util.*;

public class UserIOImpl implements UserIO {
    final private Scanner console = new Scanner(System.in);


    @Override
    public void print(String msg) {
        System.out.println(msg); //Receives a message and displays/ prints it on the screen.
    } //

    @Override
    public String readString(String msgPrompt) { //Receives a message to print on the screen.
        System.out.println(msgPrompt);
        return console.nextLine(); //Reads in a new message.
    }

    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // We will see if the input from the user is of the form we need, i.e. an integer. So we read it and
                // store it in the String called stringValue.
                String stringValue = this.readString(msgPrompt);
                // We transform it into an integer.
                num = Integer.parseInt(stringValue);
                // If we manage to make it an integer, then it is a valid form so, invalidInput is now false.
                invalidInput = false;
            } catch (NumberFormatException e) {
                //In case the format is invalid, we print an error.
                this.print("Input error. Please try again.");
            }
        }
        return num; // Integer anymore.
    }


    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result; //Starts from the default value, i.e. 0 so that do while can be properly executed.
        do {
            result = readInt(msgPrompt);//readInt gives us an integer so no need to worry about its format.
        } while (result < min || result > max);

        return result;
    }

    @Override
    public long readLong(String msgPrompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }


    @Override
    public long readLong(String msgPrompt, long min, long max) {
        long result;
        do {
            result = readLong(msgPrompt);
        } while (result < min || result > max);

        return result;
    }


    @Override
    public float readFloat(String msgPrompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }


    @Override
    public float readFloat(String msgPrompt, float min, float max) {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while (result < min || result > max);

        return result;
    }


    @Override
    public double readDouble(String msgPrompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(msgPrompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }


    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while (result < min || result > max);
        return result;
    }


}




