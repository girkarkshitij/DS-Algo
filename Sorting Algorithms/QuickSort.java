/**
 * Worst-case performance	          O(n^2) (Shuffle the array to avoid this)
 * Best-case performance	          O(n log n) (simple partition)
 *                                  or O(n) (three-way partition and equal keys)
 * Average performance	            O(n log n)
 * Worst-case space complexity	    O(n) auxiliary (naive)
 *                                  O(log n) auxiliary (Sedgewick 1978)
 */
class QuickSort{
    private int partition(int[] a, int lo, int hi){
        int i=lo;
        int j=hi+1;

        while (true){
            while (a[++i] < a[lo]) {
                if (i == hi)
                    break;
            }
            while (a[--j] > a[lo]){
                if (j == lo)
                    break;
            }
            if (i>=j)
                break;
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }

        int temp=a[j];
        a[j]=a[lo];
        a[lo]=temp;

        return j;
    }

    public void sort(int[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
}
public class Main{
    public static void main(String[] args) {
        int[] array={9,8,7,6,5,4,3,2,1};
        QuickSort quickSort=new QuickSort();
        quickSort.sort(array,0,array.length-1);
        for (int a :
                array) {
            System.out.print(a+" ");
        }
    }
}
