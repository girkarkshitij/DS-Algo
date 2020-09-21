/**
 *  Segmented Sieve - To print all prime numbers between l to r
 *  and r is too large to use normal sieve (with memory O(n))
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        printPrimes(50, 100);
    }

    public static ArrayList<Integer> normalSieve(int n){
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, 2, n+1, true);

        for (int i = 2; i * i <= n ; i++) {
            if (isPrime[i]){
                for (int j = i * i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                list.add(i);
        }
        return list;
    }

    public static void printPrimes(int l, int r){
        ArrayList<Integer> primes = normalSieve((int) Math.sqrt(r));
        boolean[] isPrime = new boolean[r - l + 1];
        Arrays.fill(isPrime, true);
        for(int i: primes){
            // Smaller or equal value to l
            int base = (l / i) * i;
            if (base < l)
                base += i;

            // Marking all multiples as false
            for (int j = base; j <= r ; j+=i) {
                isPrime[j - l] = false;
            }

            // If base is itself a prime number
            if (base == i){
                isPrime[base - l] = true;
            }
        }

        for (int i = 0; i <= r - l; i++) {
            if (i+l == 1)
                continue;
            else if (isPrime[i])
                System.out.println(i+l);
        }
    }
}
