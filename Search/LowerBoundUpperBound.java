class Main2{
    public static void main(String[] args) {
        int[] a={5,5,7,7,7,8,8,8,9};
        System.out.println(lowerBound(a, 6));  //2
        System.out.println(lowerBound(a, 7));  //2

        System.out.println(upperBound(a, 6));  //2
        System.out.println(upperBound(a, 7));  //5

        System.out.println(lowerBound(a, 5));  //0

        System.out.println(upperBound(a, 9));  //8

        System.out.println(lowerBound(a, 1));  //0

        System.out.println(upperBound(a, 10)); //8

    }

    /**
     *
     * @return It returns index of first element which is grater than searched value.
     *         If searched element is bigger than any array element function returns -1
     */
    public static int upperBound(int[] array,int value) {
        int low = 0;
        int high = array.length-1;
        while (low < high) {
            final int mid = low + (high - low) / 2;
            if (value >= array[mid])
                low = mid + 1;
            else
                high = mid;
        }
        if (low == array.length-1){
            if (array[low] > value)
                return low;
            else
                return -1;  //Element not found
        }
        return low;
    }

    /**
     *
     * @return If searched element doesn't exist function returns index of first element which is bigger than searched value.
     *         If searched element is bigger than any array element function returns the last index.
     *         If searched element is lower than any array element function returns index of first element.
     *
     */
    public static int lowerBound(int[] array, int value) {
        int low = 0;
        int high = array.length-1;
        while (low < high) {
            final int mid = low + (high - low) / 2;
            if (value <= array[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
