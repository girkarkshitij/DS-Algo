/**
 * The N Queen is the problem of placing N chess queens 
 * on an N×N chessboard so that no two queens attack each other. 
 */

class Main{
    static final int MAX=50;
    static int[] x = new int[MAX];

    public static void main(String[] args) {
        NQueen(1, 4);
        
        //2 4 1 3 
        //3 1 4 2 
    }

    public static void NQueen(int k,int n){
        for (int i = 1; i <= n; i++) {
            if (place(k, i)){
                x[k] = i;
                if (k == n)
                    printArray(x, n);
                else
                    NQueen(k+1, n);
            }
        }
    }

    private static void printArray(int[] x,int n) {
        for(int i=1; i<=n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    //Check if the position is valid or not
    public static boolean place(int k,int i){
        for (int j = 1; j <=k-1 ; j++) {
            if ((x[j]==i) || (Math.abs(x[j]-i)==Math.abs(j-k)))
                return false;
        }
        return true;
    }
}
