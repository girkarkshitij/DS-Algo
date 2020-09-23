/**
 * Extended Euclidean Algorithm
 * It computes the GCD of two numbers using the extended Euclid's algorithm
 * It also prints a and b such that a(p) + b(q) = gcd(p, q) i.e Bézout's identity
 */

class Main{
    public static void main(String[] args) {
        int p = 18;
        int q = 200;
        int values[] = gcd(18, 200);
        System.out.println("gcd(" + p + ", " + q + ") = " + values[0]);
        System.out.println(values[1] + "(" + p + ") + " + values[2] + "(" + q + ") = " + values[0]);

        // gcd(18, 200) = 2
        // -11(18) + 1(200) = 2
    }
    
    public static long[] gcd(long p, long q) {
        if (q == 0)
            return new long[] { p, 1, 0 };

        long[] values = gcd(q, p % q);
        long d = values[0];
        long a = values[2];
        long b = values[1] - (p / q) * values[2];
        return new long[] { d, a, b };
    }
}
