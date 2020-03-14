//Time Complexity: O(n^2) as there are two nested loops.
//Auxiliary Space: O(1)

import java.util.Scanner;

class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for (int i = 0; i <n ; i++) {
            array[i]=scanner.nextInt();
        }
        array= selectionSort(array);
        for (int a :
                array) {
            System.out.println(a);
        }
    }

    private static  int[] selectionSort(int[] array) {
        for (int i = 0; i <array.length-1 ; i++) {
            int min=Integer.MAX_VALUE;
            int index=-1;
            for (int j = i+1; j <array.length ; j++) {
                if (array[j] < min) {
                    index = j;
                    min = array[j];
                }
            }
            if (array[index]<array[i]){
                int temp=array[index];
                array[index]=array[i];
                array[i]=temp;
            }
        }
        return array;
    }
}
