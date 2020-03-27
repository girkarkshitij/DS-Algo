// 1<< i is equal to 2^i

class Test{
    public static void main(String[] args) {
        int n=8;
        int[] a={15, 22, 14, 26, 32, 9, 16, 8};
        int S=53;

        boolean found=false;
        for(int mask = 0; mask < (1 << n); mask++) {
            int sum_of_this_subset = 0;
            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) >0) {
                    sum_of_this_subset += a[i];
                }
            }
            if(sum_of_this_subset == S) {
                found=true;
                System.out.println("Yes");
                break;
            }
        }
        if (!found)
            System.out.println("No");
    }
}
