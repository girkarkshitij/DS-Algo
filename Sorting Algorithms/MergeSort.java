/**
 * Worst-case performance-->	    O(n log n)
 * Best-case performance--> 	    O(n log n) typical, O(n) natural variant
 * Average performance-->	        O(n log n)
 * Worst-case space complexity-->	О(n) total with O(n) auxiliary, O(1) auxiliary with linked lists[1]
 */

class Merge{
    private static int[] aux;

    public void sort(int[] a){
        aux=new int[a.length];
        sort(a,0,a.length-1);
    }

    public void sort(int[] a,int lo,int hi){
        if (hi<=lo)
            return;
        int mid=lo+(hi-lo)/2;
        sort(a,0,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public void merge(int[] a,int lo,int mid,int hi){
        int i=lo;
        int j=mid+1;
        int[] aux=new int[a.length];

        for (int k = lo; k <=hi  ; k++) {
            aux[k]=a[k];
        }

        for (int k = lo; k <=hi ; k++) {
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

}
class Main{
    public static void main(String[] args) {
        int[] array={99,4,45,45,45,45,48,78,5,2,36};
        Merge m1=new Merge();
        m1.sort(array);
        for (int a :
                array) {
            System.out.print(a+" ");
        }
    }
}
