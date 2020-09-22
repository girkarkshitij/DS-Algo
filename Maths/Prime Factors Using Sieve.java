/**
 * Prime Factorization using Sieve
 * Time : O(log n) in worst case (When the number is a power of 2)
 */

import java.util.ArrayList;

public class Main{
    static final int MAX = 100001;
    static int[] spf = new int[MAX];  // spf : smallest prime factor

    public static void main(String[] args) {
        sieve();
        System.out.println(primeFactors(2727));  // [3, 3, 3, 101]
    }

    public static void sieve(){
        spf[1] = 1;
        for (int i = 2; i < MAX; i++) {
            spf[i] = i;
        }

        // Marking all even numbers as not prime
        for (int i = 4; i < MAX; i+=2) {
            spf[i] = 2;
        }

        for (int i = 3; i * i < MAX; i+=2) {
            if (spf[i] == i) {
                // Number is prime
                for (int j = i * i; j < MAX; j+=i) {
                    // Mark only if it is not previously marked
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }
    }

    public static ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        while (n != 1) {
            list.add(spf[n]);
            n = n / spf[n];
        }

        return list;
    }
}
