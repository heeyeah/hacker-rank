package hacker.rank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingSort2 {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {

        int[] output = new int[100];

        for(int el : arr) {
            output[el]++;
        }

        int index= 0;
        for(int i = 0 ; i < output.length ; i++) {

            while(output[i]-- > 0) {
                arr[index++] = i;
            }
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = countingSort(arr);

        System.out.println(Arrays.toString(result));
        scanner.close();
    }
}
