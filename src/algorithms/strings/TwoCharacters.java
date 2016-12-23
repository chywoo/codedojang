package algorithms.strings;

import java.io.*;
import java.lang.reflect.Array;
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
        HashSet<Character> setOrigin = new HashSet<>();
        Character[] letters;


        for(int i = 0; i < len; i++)
            setOrigin.add(s.charAt(i));

        letters = setOrigin.toArray(new Character[len]);


        len = setOrigin.size();

        for(int i = 0; i < len -1; i++)
        {
            for(int j = i + 1; j < len; j++)
            {
                String data = s;

                for( int k = 0; k < len; k++)
                {
                    char c;

                    if ( k == j || k == i ) continue;

                    c = letters[k];
                    data = data.replace(c, ' ');
                }

                if (isValid(data))
                    max = Math.max(max, data.length());
            }
        }

        System.out.println("Answer: " + max);
    }

    private static boolean isValid(String str) {
        int len = str.length();

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < len; i++)
        {
            if ( str.charAt(i) == ' ') continue;

            buffer.append(str.charAt(i));
        }

        if ( len < 3 )
            return true;

        str = buffer.toString();
        len = buffer.length();

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

