public class Main{
    public static void main(String[] args) {
        System.out.println(modInverse(10, 17));  
        //Output: 12
        //Since (10*12) mod 17 = 1, 12 is modulo inverse of 10(under 17).
    }

    public static long mod(long a, long m){
        long ans = a % m;
        return ans >= 0 ? ans : ans + m;
    }

    /**
     * m > 0 and gcd(a, m) = 1
     * @return Modular multiplicative inverse
     */

    public static long modInverse(long a, long m){
        a = mod(a, m);
        return a == 0 ? 0 : mod((1 - (long) modInverse(m % a, a) * m) / a, m);
    }
}
