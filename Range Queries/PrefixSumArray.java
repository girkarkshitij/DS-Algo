/**
 * Sum Queries
 * Construction of prefix sum array: O(n)
 * Query: O(1)
 */

class Range{
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 8, 6, 1, 4, 2};
        SumQuery sumQuery  = new SumQuery(a);
        System.out.println(sumQuery.sum(0, 0));  //1
        System.out.println(sumQuery.sum(3,6));   //19
    }
}

class SumQuery{
    long[] array;
    int n;

    public SumQuery(int[] input){
        n = input.length;
        array = new long[n];
        array[0] = input[0];

        for (int i = 1; i < n; i++) {
            array[i] = input[i] + array[i-1];
        }
    }

    public long sum(int start, int end){
        long first = 0, second = 0;
        if (start!=0)
            second = array[start-1];

        first = array[end];

        return first - second;
    }
}

