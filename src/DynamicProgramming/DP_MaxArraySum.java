package DynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    By: Tszyan "Kenneth" Wong

    Link to the problem: https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming

    Sample Input 0:

        5
        3 7 4 6 5

    Sample Output 0:

        13
 */
public class DP_MaxArraySum {
    static int maxSubsetSum(int[] arr) {
        // set base cases
        arr[0] = Math.max(0, arr[0]);
        arr[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i-1], arr[i] + arr[i-2]);
        }
        // return the last element which contains the largest element
        return arr[arr.length - 1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
