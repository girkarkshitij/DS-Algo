/**
 * Fibonacci Numbers using Matrix Exponentiation and Dynamic Programming
 */

public class Main{
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci.find(i));
        }
    }
}

class Fibonacci {
    private final long[][][] dp;

    public Fibonacci() {
        dp = new long[64][2][2];
        dp[0] = new long[][]{{1, 1}, {1, 0}};

        for (int i = 1; i < dp.length ; i++) {
            dp[i] = square(dp[i - 1]);
        }
    }

    private long[][] square(long[][] a){
        return multiply(a, a);
    }

    private long[][] multiply(long[][] a, long[][] b){
        long[][] c = new long[a[0].length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public long find(int n){
        if (n == 0 || n == 1){
            return 1;
        }else{
            long[][] matrix = binaryExpo(n - 1);
            return matrix[0][0] + matrix[0][1];
        }
    }

    private long[][] binaryExpo(int n){
        long[][] result = new long[][]{{1, 1},{0, 1}};
        for (int i = 31; i >= 0 ; i--) {
            if ((n & (1 << i)) != 0){
                result = multiply(result, dp[i]);
            }
        }
        return result;
    }
}
