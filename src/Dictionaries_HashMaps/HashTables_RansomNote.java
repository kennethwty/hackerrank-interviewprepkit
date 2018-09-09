package Dictionaries_HashMaps;

import java.util.HashMap;
import java.util.Scanner;

/*
    By: Tszyan "Kenneth" Wong

    Link to the problem: https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

    Sample Input 0:

        6 4
        give me one grand today night
        give one grand today

    Sample Output 0:

        Yes

    Sample Input 1:

        6 5
        two times three is not four
        two times two is four

    Sample Output 1:

        No
 */
public class HashTables_RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        if(note.length > magazine.length) {
            System.out.println("No");
            return;
        }

        // note: HashMap replaces the old value for duplicate keys
        HashMap<String, Integer> map = new HashMap<>();
        for(String mWord : magazine) {
            // if it contains the key, add 1 to its value
            if(map.containsKey(mWord)) {
                map.put(mWord, map.get(mWord) + 1);
            } else {
                map.put(mWord, 1);
            }
        }

        for(String s : note) {
            if(map.containsKey(s) && map.get(s) > 0) {
                map.put(s, map.get(s) - 1);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
