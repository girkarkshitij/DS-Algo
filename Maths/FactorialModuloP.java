public class Main {
    public static void main(String[] args) {
        System.out.println(modFact(25, 29));
        //5
    }

    /**
     * Modular exponentiation
     * @return (x^y)%p
     */
    public static long power(long x, long y, long p) {
        long ans = 1;
        x = x % p;

        while (y > 0) {
            if ((y & 1) > 0)
                ans = (ans * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return ans;
    }

    /**
     * Modular Inverse using Fermat's Little Theorem
     * @param p is a prime number
     * @return Inverse of a (mod p)
     */
    public static long modInverse(long a, long p) {
        return power(a, p-2, p);
    }

    /**
     * @return n! mod p using Wilson's Theorem
     * Time: O(plogn)
     */

    public static long modFact(long n, long p) {
        if (p <= n)
            return 0;

        long ans = p - 1;

        for (int i = (int) (n + 1); i < p; i++) {
            ans = (ans * modInverse(i, p)) % p;
        }
        return ans;
    }
}
