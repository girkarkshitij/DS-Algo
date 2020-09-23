public class Main {
    public static void main(String[] args) {
        int[] values = new Diophantine().findAnySolution(-7, 3, 5);
        System.out.println("x: "+ values[0] +" "+ "y: "+ values[1]);
        // x: -5 y: -10
        // true

        System.out.println(new Diophantine().findAllSolutions(-7, 3, 5, 0, 100, 0, 100));
        // 14
    }

}

class Diophantine {
    int x;
    int y;

    /**
     * Extended Euclid Algorithm
     */
    public int[] gcd(int p, int q) {
        if(q == 0)
            return new int[] { p, 1, 0 };

        int[] values = gcd(q, p % q);
        int d = values[0];
        int a = values[2];
        int b = values[1] - (p / q) * values[2];
        return new int[] {d, a, b};
    }

    /**
     * @return A single solution for given values
     */
    public int[] findAnySolution(int a, int b, int c) {
        int[] values = gcd(Math.abs(a), Math.abs(b));
        int g = values[0];
        int x0 = values[1];
        int y0 = values[2];

        if (c % g != 0) {
            System.out.println("No solution");
            return new int[]{};
        }

        x0 *= c / g;
        y0 *= c / g;

        if (a < 0)
            x0 = -x0;
        if (b < 0)
            y0 = -y0;

        return new int[]{ x0, y0 , g};
    }

    /**
     * @return Number of solutions in the given interval
     */
    public int findAllSolutions(int a, int b, int c, int minx, int maxx, int miny, int maxy) {
        int[] values = findAnySolution(a, b, c);

        if (values.length == 0)
            return 0;

        x = values[0];
        y = values[1];
        int g = values[2];

        a /= g;
        b /= g;

        int sign_a = a > 0 ? +1 : -1;
        int sign_b = b > 0 ? +1 : -1;

        shiftSolution(a, b, (minx - x) / b);
        if (x < minx)
            shiftSolution(a, b ,sign_b);
        if (x > maxx)
            return 0;
        int lx1 = x;

        shiftSolution(a, b, (maxx - x) / b);
        if (x > maxx)
            shiftSolution(a, b, -sign_b);
        int rx1 = x;

        shiftSolution(a, b, -(miny - y) / a);
        if (y < miny)
            shiftSolution(a, b, -sign_a);
        if (y > maxy)
            return 0;
        int lx2 = x;

        shiftSolution(a, b, -(maxy - y) / a);
        if (y > maxy)
            shiftSolution(a, b, sign_a);
        int rx2 = x;

        if (lx2 > rx2) {
            int temp = lx2;
            lx2 = rx2;
            rx2 = temp;
        }
        int lx = Math.max(lx1, lx2);
        int rx = Math.min(rx1, rx2);

        if (lx > rx)
            return 0;
        return (rx - lx) / Math.abs(b) + 1;

        //Once we have lx and rx, it is also simple to enumerate through all the solutions. Just need to iterate through
        //x=lx + k⋅(b/g) for all k≥0 until x = rx, and find the corresponding y values using the equation ax + by = c.
    }

    public void shiftSolution(int a, int b, int count) {
        x += count * b;
        y -= count * a;
    }
}
