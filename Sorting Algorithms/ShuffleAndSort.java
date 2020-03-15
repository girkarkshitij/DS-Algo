/**
 * To avoid the worst-case runtime of O(n^2) for an almost sorted array,
 * we will first shuffle it and then apply Arrays.sort()
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for (int i = 0; i <n ; i++) {
            array[i]=scanner.nextInt();
        }
        array= shuffleAndSort(array);
        for (int a :
                array) {
            System.out.println(a);
        }
    }

    public static int[] shuffleAndSort(int[] a){
        int n = a.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n-i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
        Arrays.sort(a);
        return a;
    }
}
