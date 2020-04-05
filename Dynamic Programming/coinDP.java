/**
 * Given a set of coin values coins = {c1, c2, c3..., cn} and a target sum of
 * money n, our task is to form the sum n using as few coins as possible.
 */

class Main{
    static int N = 10000;
    static int INFINITY = Integer.MAX_VALUE;
    static int[] dp = new int[N];
    static int[] coins = {1, 3, 4};

    public static void main(String[] args) {
        dp[0] = 0;  //Base case
		
        for (int x = 1; x < N; x++) {
            dp[x] = INFINITY;
            for(int c: coins){
                if (x - c >= 0)
                    dp[x] = Math.min(dp[x], dp[x - c]+1);
            }
        }

        int[] queries = {1, 2, 6, 7, 10};
        for (int i = 0; i <queries.length ; i++) {
            System.out.println("Minimum no of coins required for "+queries[i]+"="+dp[queries[i]]);
        }
    }
}
