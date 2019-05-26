package hacker.rank;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    static int max = Integer.MIN_VALUE;
    static Stack<StackStrct> stack = new Stack<StackStrct>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        for(int i = 0 ; i < count ; i++) {

            doWork(sc.nextLine());
        }


        sc.close();
    }


    private static void doWork(String command) {

        if(command.startsWith("1")) {

            int val = Integer.parseInt(command.split(" ")[1]);
            max = Math.max(val, max);
            stack.push(new StackStrct(val, max));

        } else if (command.equals("2")) {

            if(!stack.isEmpty()) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                max = Integer.MIN_VALUE;
            } else {
                max = stack.peek().getMax();
            }

        } else {
            if(!stack.isEmpty()) System.out.println(stack.peek().getMax());
        }


    }

}

class StackStrct {
    private int value;
    private int max;

    StackStrct(int value, int max) {
        this.value = value;
        this.max = max;
    }

    public int getValue() {
        return value;
    }
    public int getMax() {
        return max;
    }
}