/**
 * Construction of 2D prefix sum array: O(r*c)
 * Auxiliary Space Required: O(r*c)
 * Query: O(1)
 */

class Range{
    public static void main(String[] args) {
        int[][] a = {{1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1}};
        SumQuery2D sumQuery2D = new SumQuery2D(a);
        System.out.println(sumQuery2D.sumQuery(0,0,4,4));  //25
        System.out.println(sumQuery2D.sumQuery(0,0,0,0));  //1

    }
}

class SumQuery2D{
    int[][] array;

    public SumQuery2D(int[][] input) {
        int r = input.length;
        int c = input[0].length;

        array = new int[r][c];
        array[0][0] = input[0][0];

        //first row
        for (int i = 1; i < c; i++) {
            array[0][i] = array[0][i - 1] + input[0][i];
        }
        //first column
        for (int i = 1; i < r; i++) {
            array[i][0] = array[i - 1][0] + input[i][0];
        }
        //general formula for other cells
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1] + input[i][j];
            }
        }
    }

    public int sumQuery(int row1, int col1, int row2, int col2) {
        int res = array[row2][col2];

        if (row1 > 0)
            res = res - array[row1-1][col2];

        if (col1 > 0)
            res = res - array[row2][col1-1];

        if (row1 > 0 && col1 > 0)
            res = res + array[row1-1][col1-1];

        return res;
    }
}

