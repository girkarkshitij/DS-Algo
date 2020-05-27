/**
 * Worst Case: O(n^2)
 * Best Case: O(n)
 * Average Case: O(n^2)
 */

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a){
        int n = a.length;

        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }
}
