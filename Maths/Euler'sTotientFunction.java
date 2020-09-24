import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+":" + phi(i));
        }
        phiFrom1tonDivisorSum(10);
        phiFrom1tonSieve(10);
//        1:1
//        2:1
//        3:2
//        4:2
//        5:4
//        6:2
//        7:6
//        8:4
//        9:6
//        10:4
    }

    /**
     * @return phi(n) in O(Sq.root of n)
     */
    public static int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0)
                    n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

    /**
     * Based on Sieve of Eratosthenes
     * Prints phi(i) for all i between 1 to n in O(nloglogn)
     */
    public static void phiFrom1tonSieve(int n) {
        ArrayList<Integer> phi = new ArrayList<>(n + 1);
        phi.add(0);
        phi.add(1);

        for (int i = 2; i <= n; i++) {
            phi.add(i);
        }

        for (int i = 2; i <= n ; i++) {
            if (phi.get(i) == i) {
                for (int j = i; j <= n; j+=i) {
                    int temp = phi.get(j);
                    phi.set(j, temp - (temp / i));
                }
            }
        }
        System.out.println(phi);
    }

    /**
     * Based on the divisor sum property
     * Prints phi(i) for all i between 1 to n in O(nlogn)
     */
    public static void phiFrom1tonDivisorSum(int n) {
        ArrayList<Integer> phi = new ArrayList<>(n + 1);
        phi.add(0);
        phi.add(1);

        for (int i = 2; i <= n; i++) {
            phi.add(i - 1);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j+=i) {
                //phi[j] = phi[j] - phi[i];
                phi.set(j, phi.get(j) - phi.get(i));
            }
        }
        System.out.println(phi);
    }
}
