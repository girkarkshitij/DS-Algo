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

    static int[] gcd(int p, int q) {
        if (q == 0)
            return new int[] { p, 1, 0 };

        int[] values = gcd(q, p % q);
        int d = values[0];
        int a = values[2];
        int b = values[1] - (p / q) * values[2];
        return new int[] { d, a, b };
    }
}
