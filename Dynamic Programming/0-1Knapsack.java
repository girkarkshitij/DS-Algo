/**
 * 0-1 Knapsack Probelem - Dynamic Programming (bottom up manner)
 */

class Test {
    static int knapSack(int max, int[] weight, int[] profit, int n) {
        int[][] B = new int[n+1][max+1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= max; j++) {
                if (i==0 || j==0)
                    B[i][j] = 0;
                else if (weight[i-1] <= j)
                    B[i][j] = Math.max(profit[i-1] + B[i-1][j-weight[i-1]], B[i-1][j]);
                else
                    B[i][j] = B[i-1][j];
            }
        }
        return B[n][max];
    }

    public static void main(String[] args) {
        int[] profit = new int[]{3, 4, 5, 6};
        int[] weight = new int[]{2, 3, 4, 5};
        int max = 5;
        int n = profit.length;
        System.out.println(knapSack(max, weight, profit, n));
		
        /** 
         *    Output:
         *      0   1   2   3   4   5
         *   _________________________
         *   0 |0   0   0   0   0   0
         *   1 |0   0   3   3   3   3
         *   2 |0   0   3   4   4   7
         *   3 |0   0   3   4   5   7
         *   4 |0   0   3   4   5   7
         */
    }
}
