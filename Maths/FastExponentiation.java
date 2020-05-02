/**
 *  Time Complexity: O(log b)
 */

class Main{
    static int MOD = 1000000007;
	
    public static void main(String[] args) {
        System.out.println(power(2,5));
        //32
    }

    public static long power(int a, int b){
        long ans = 1;

        while (b > 0){
            if (b % 2 != 0)
                ans  = ans * a;

            b = b/2;
            a = a * a;
        }

        return ans;
    }

    public static long modPower(int a, int b){
        long ans = 1;

        while (b > 0){
            if (b % 2 != 0)
                ans = ((ans % MOD)*(a % MOD))%MOD;

            b = b/2;
            a = ((a % MOD)*(a % MOD))% MOD;
        }

        return ans;
    }
}
