package hacker.rank;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndTheValidString {

    // Complete the isValid function below.
    private static String isValid(String s) {


        int[] countChar = new int[26];

        for (char c : s.toCharArray()) {
            countChar[c - 97]++;
        }

        countChar = Arrays.stream(countChar).filter(e -> e > 0).sorted().toArray();

        int countCharLength = countChar.length;

        int[] disinctArr = Arrays.stream(countChar).distinct().toArray();

        if (disinctArr.length == 1) {
            return "YES";
        } else if (disinctArr.length == 2) {

            if (countChar[0] + 1 == countChar[1]
                    || countChar[countCharLength - 1] - 1 == countChar[countCharLength - 2]
                    || (countChar[0] == 1 && countChar[1] != 1)) {
                return "YES";

            } else {
                return "NO";
            }
        } else {
            return "NO";
        }

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);
        scanner.close();
    }
}

