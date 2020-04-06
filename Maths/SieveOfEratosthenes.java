//Using Sieve of Eratosthenes,
//Create an array of all the prime numbers from 1 to n.
import java.util.Arrays;

class Test{
    public static void main(String[] args) {
        int[] primeNumbers = generatePrimes(30);
        for(int prime : primeNumbers)
            System.out.print(prime+" ");

        //2 3 5 7 11 13 17 19 23 29
    }

    public static int[] generatePrimes(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, 2, n+1, true);

        for (int i = 2; i*i <= n ; i++) {
            if (isPrime[i]){
                for (int j = i*i; j <=n ; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primes = new int[n+1];
        int count = 0;
        for (int i = 0; i < isPrime.length ; i++) {
            if (isPrime[i])
                primes[count++] = i;
        }

        return Arrays.copyOf(primes, count);
    }
}
