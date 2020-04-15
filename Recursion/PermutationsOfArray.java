/**
 * Generate all permutations of the given array.
 * (Recursive Method)
 */

import java.util.ArrayList;
import java.util.Scanner;

class Test{
    static int n  ;
    static int[] a ;
    static boolean[] chosen ;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        chosen = new boolean[n];
        search();
    }

    static void search () {
        if (list.size() == n) {
            //Process the permutation
            for (int v : list)
                System.out.print(v + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (chosen[i])
                    continue;
                chosen[i] = true;
                list.add(a[i]);
                search();
                chosen[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * Input:
     * 3
     * 0 1 2
     *
     * Output:
     * 0 1 2
     * 0 2 1
     * 1 0 2
     * 1 2 0
     * 2 0 1
     * 2 1 0
     */
}
