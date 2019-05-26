package hacker.rank;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

    static Map<Character, Character> bracketsMap = new HashMap<Character, Character>();


    static String isBalanced(String s) {

        if(s.length() == 1) {
            return "NO";
        }

        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()) {

            if(bracketsMap.containsKey(c)) {
                stack.push(c);
            } else {

                if(stack.isEmpty()) {
                    return "NO";
                }

                if(bracketsMap.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        if(!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        bracketsMap.put('(', ')');
        bracketsMap.put('{', '}');
        bracketsMap.put('[', ']');
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }


        scanner.close();
    }
}

