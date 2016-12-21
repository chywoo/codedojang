package algorithms.strings;

import java.io.*;
import java.util.*;

public class TwoCharacters {
    public static String input = "10\n" +
            "beabeefeab";

    public static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {

        InputStream is = new ByteArrayInputStream(input.getBytes());
        Scanner in = new Scanner(is);
        int len = in.nextInt();
        String s = in.next();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < len; i++)
            set.add(s.charAt(i));

    }

    private static boolean isValid(String str) {
        int len = str.length();

        if ( len < 3 )
            return true;

        for ( int i = 0; i < len - 2; i++)
        {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            char c = str.charAt(i + 2);

            if ( a - b != c - b)
                return false;
        }

        return true;
    }
}

