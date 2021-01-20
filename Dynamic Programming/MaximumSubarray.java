/**
 * Kadane's algorithm for Maximum subarray problem
 * Time complexity : O(n)
 */
 
class Test{
    public static void main(String[] args) {
        int a[] = {-1, 2, 4, -3, 5, 2, -5, 2};
        int n = a.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0)
                sum = 0;
            max = Math.max(max, sum);
        }

        System.out.println("Maximum sum is "+max);
        //Maximum sum is 10
    }
}
