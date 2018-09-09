package Sorting;

import java.util.Scanner;

/*
    By: Tszyan "Kenneth" Wong

    Link to the problem: https://www.hackerrank.com/challenges/30-sorting/problem

    Sample Input 0:
        3
        1 2 3

    Sample Output 0:
        Array is sorted in 0 swaps.
        First Element: 1
        Last Element: 3

    Sample Input 1:
        3
        3 2 1

    Sample Output 1:
        Array is sorted in 3 swaps.
        First Element: 1
        Last Element: 3
 */
public class Sorting_BubbleSort {
    static void countSwaps(int[] arr) {
        int numOfSwaps = 0;

        for(int last = arr.length - 1; last > 0; last--) {
            boolean swapped = false;
            for(int j = 0; j < last; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    numOfSwaps++;
                    swapped = true;
                }
            }
            if(swapped == false) break;
        }

        System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length-1]);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
