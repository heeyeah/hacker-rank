package hacker.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TheFullCountingSort {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {

        for (int i = 0; i < arr.size() / 2; i++) {
            arr.get(i).add("-");
        }

        arr.sort((el1, el2) -> {
        	int i1 = Integer.parseInt(el1.get(0));
        	int i2 = Integer.parseInt(el2.get(0));
        	
        	if(i1 < i2) {
        		return -1;
        	} else if (i1 == i2) {
        		return 0;
        	} else {
        		return 1;
        	}
            
        });


        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {

            List<String> el = arr.get(i);

            if (el.size() > 2) {
                sb.append(el.get(2));
            } else {
                sb.append(el.get(1));
            }
            if (i != arr.size()) sb.append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}
