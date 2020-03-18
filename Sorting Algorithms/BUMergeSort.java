/**
 * (Same as recursive version of merge sort)
 * 
 * Worst-case performance-->	    O(n log n)
 * Best-case performance--> 	    O(n log n) typical, O(n) natural variant
 * Average performance-->	        O(n log n)
 * Worst-case space complexity-->	О(n) total with O(n) auxiliary, O(1) auxiliary with linked lists[1]
 */

class BUMerge {
    private static int[] aux;

    public void sort(int[] a){
        int n=a.length;
        aux=new int[n];

        for (int size = 1; size <n ; size=size+size) {
            for (int lo = 0; lo <n-size ; lo+=size+size) {
                merge(a, lo, lo+size-1, Math.min(lo+size+size-1, n-1));
            }
        }
    }

    public void merge(int[] a,int lo,int mid,int hi){
        int i=lo;
        int j=mid+1;
        int[] aux=new int[a.length];

        for (int k = lo; k <=hi  ; k++) {
            aux[k]=a[k];
        }

        for (int k = lo; k <=hi ; k++)
            if (i>mid)
                a[k]=aux[j++];
            else if (j>hi)
                a[k]=aux[i++];
            else if (aux[j]<aux[i])
                a[k]=aux[j++];
            else
                a[k]=aux[i++];
    }

}
class Main{
    public static void main(String[] args) {
        int[] array={7,4,8,5,9,5,6,9,5,9,7,8,5,4,6,5,9};
        BUMerge m1=new BUMerge();
        m1.sort(array);
        for (int a :
                array) {
            System.out.print(a+" ");
        }
    }
}
