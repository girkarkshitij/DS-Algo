import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(factMod(7, 3));
        // 2
    }

    /**
     * @return n! mod p without taking all the multiple factors of p into account
     */
    public static int factMod(int n, int p) {
        ArrayList<Integer> f = new ArrayList<>(p);
        f.add(1);

        for (int i = 1; i < p; i++) {
            f.add(f.get(i - 1) * i % p);
        }

        int res = 1;
        while (n > 1) {
            if ((n/p) % 2 == 1)
                res = p - res;
            res = res * f.get(n%p) % p;
            n /= p;
        }
        return res;
    }
}
