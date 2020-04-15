/**
 * Kadane's algorithm for Maximum subarray problem
 * Time complexity : O(n)
 */
 
class Test{
    public static void main(String[] args) {
        int a[] = {-1, 2, 4, -3, 5, 2, -5, 2};
        int n = a.length;
        int best = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = Math.max(a[i], sum+a[i]);
            best = Math.max(best, sum);
        }

        System.out.println("Maximum sum is "+best);
        //Maximum sum is 10
    }
}
