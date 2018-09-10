package StringManipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
    By: Tszyan "Kenneth" Wong

    Link to the problem: https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

    Sample Input:

        5
        AAAA
        BBBBB
        ABABABAB
        BABABA
        AAABBB

    Sample Output:

        3
        4
        0
        0
        4
 */
public class Strings_AlternatingCharacters {
    static int alternatingCharacters(String s) {
        boolean previousIsA = s.charAt(0) == 'A' ? true : false;
        int deletion = 0;

        for(int i = 1; i < s.length(); i++) {
            // If the character is A and the previous character is also A, delete it.
            if(s.charAt(i) == 'A' && previousIsA) deletion++;
                // If the character is B and the previous character is A,
            else if(s.charAt(i) == 'B' && previousIsA) previousIsA = false;
                // If the character is A and the previous character is NOT A,
            else if(s.charAt(i) == 'A' && !previousIsA) previousIsA = true;
                // The character is B and the previous character is also B. delete it.
            else deletion++;
        }
        return deletion;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
