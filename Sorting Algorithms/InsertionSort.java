/**
 * Time Complexity--> Best: O(N), Average: O(N^2), Worst: O(N^2)
 * Space Complexity--> O(1)
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
        array= insertionSort(array);
        for (int a :
                array) {
            System.out.println(a);
        }
    }

    public static  int[] insertionSort(int[] array) {
        int n=array.length;
        for (int i = 1; i <n ; i++) {
            int value=array[i];
            int empty=i;
            while (empty>0 && array[empty-1]>value){
                array[empty]=array[empty-1];
                empty--;
            }
            array[empty]=value;
        }
        return array;
    }
}
