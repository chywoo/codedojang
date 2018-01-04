package thirtydays;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Data Types
 */
public class day1 {

    public static String input = "12\n" +
            "4.0\n" +
            "is the best place to learn and practice coding!";

    public static void main(String args[])
    {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        Scanner scan = new Scanner(is);

        /* Declare second integer, double, and String variables. */
        int myInt;
        double myDouble;
        String myString;

        /* Read and save an integer, double, and String to your variables.*/
        myInt = scan.nextInt();
        myDouble = scan.nextDouble();

        myString = scan.next();
        myString += scan.nextLine();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(myInt + i);

        /* Print the sum of the double variables on a new line. */
        System.out.println(myDouble + d);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s + myString);

        scan.close();
    }
}
