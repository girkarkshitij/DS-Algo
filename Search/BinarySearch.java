class Main2{
    public static void main(String[] args) {
        int[] a={1,2,3,4,6,7,8,9};
        System.out.println(binarySearch(a, 5));  // -1
        System.out.println(binarySearch(a, 8));  // 6
    }

    /**
     *  Worst-case performance      O(log n)
     *  Best-case performance       O(1)
     *  Average performance         O(log n)
     *  Worst-case space complexity O(1)
     */
    public static int binarySearch(int[] a,int key){
        int l = 0;
        int r = a.length-1;

        while (l <= r) {
            int midIndex = l + (r- l)/2;
            int midValue = a[midIndex];

            if (midValue < key)
                l = midIndex + 1;
            else if (midValue > key)
                r = midIndex - 1;
            else
                return midIndex; // key found
        }
        return -1;  // key not found.
    }
}
