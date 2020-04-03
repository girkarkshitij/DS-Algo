import java.util.Arrays;

public class Test{
    static final int MAX = 100;
    static int[] x = new int[MAX];
    static int[] w;
    static int targetSum;

    public static void main(String[] args) {
        w = new int[]{2, 7, 8, 15}; // Array must be sorted
        targetSum = 17;
        sumOfSubset(0 ,0, Arrays.stream(w).sum() );

        // Output:
        // 1 1 1 0
        // 1 0 0 1
    }

    /**
     *
     * @param s Current Sum
     * @param k Index
     * @param r Sum of remaining elements of the input array
     */
    public static void sumOfSubset(int s, int k, int r){
        x[k] = 1;
        if (s + w[k] == targetSum)
            answer();
        else if (s + w[k] + w[k+1]<= targetSum)
            sumOfSubset(s+w[k], k+1, r-w[k]);
        if ((s+r-w[k] >= targetSum) && (s+w[k+1] <= targetSum)){
            x[k] = 0;
            sumOfSubset(s, k+1, r-w[k]);
        }
    }

    public static void answer(){
        for (int i = 0; i < w.length; i++) {
            System.out.print(x[i]+" ");
        }
        System.out.println();
    }
}
