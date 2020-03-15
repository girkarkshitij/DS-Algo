/**
 * Worst-case performance:	O(n2) (worst known worst case gap sequence)
 *                          O(n log2n) (best known worst case gap sequence)[1]
 * Best-case performance:	O(n log n) (most gap sequences)
 *                          O(n log2n) (best known worst-case gap sequence)[2]
 * Average performance: 	depends on gap sequence
 * Worst-case space complexity:  O(1) auxiliary
 */

import java.util.Scanner;

class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for (int i = 0; i <n ; i++) {
            array[i]=scanner.nextInt();
        }
        array= shellSort(array);
        for (int a :
                array) {
            System.out.println(a);
        }
    }

    public static  int[] shellSort(int[] array) {
        //gap is reduced by 2 each time
        int n=array.length;
        for (int gap = n/2; gap >0 ; gap--) {
            for (int i = gap; i <n ;i++) {
                int temp=array[i];
                int empty=i;
                while (empty>=gap && array[empty-gap]>temp){
                    array[empty]=array[empty-gap];
                    empty-=gap;
                }
                array[empty]=temp;
            }
        }
        return array;
    }
}
