/**
 * Worst-case performance-->	    O(n log n)
 * Best-case performance--> 	    O(n log n) typical, O(n) natural variant
 * Average performance-->	        O(n log n)
 * Worst-case space complexity-->	О(n) total with O(n) auxiliary, O(1) auxiliary with linked lists[1]
 */


import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        int[] a = {4, 1, 3, 7, 9};
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] a, int l, int m, int r){
        int[] left = Arrays.copyOfRange(a, l, m+1);
        int[] right = Arrays.copyOfRange(a, m+1, r+1);

        int i = 0, j = 0, k = l;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                a[k] = left[i];
                k++;
                i++;
            }else{
                a[k] = right[j];
                k++;
                j++;
            }
        }

        if(i < left.length){
            while(i < left.length){
                a[k] = left[i];
                i++;
                k++;
            }
        }
        if(j < right.length){
            while(j < right.length){
                a[k] = right[j];
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(int[] a, int l, int r){
        if(l < r) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }
}

