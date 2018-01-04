package thirtydays;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Data Types
 */
public class day2 {

    public static String input = "12.00 20 8";
    public static InputStream is = new ByteArrayInputStream(input.getBytes());

    public static void main(String args[])
    {
        Scanner scan = new Scanner(is);

        /* Declare second integer, double, and String variables. */
        double mealPrice;
        int tipPercent, taxPercent;
        double totalCost;

        /* Read and save an integer, double, and String to your variables.*/

        mealPrice = scan.nextDouble();
        tipPercent = scan.nextInt();
        taxPercent = scan.nextInt();
        scan.close();

        totalCost = mealPrice;
        totalCost += mealPrice * tipPercent / 100.;
        totalCost += mealPrice * taxPercent / 100.;

        System.out.printf("The total meal cost is %d dollars.", Math.round(totalCost));


    }
}
