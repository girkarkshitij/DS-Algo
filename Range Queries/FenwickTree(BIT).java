class BinaryIndexedTree {

    public long[] array;
    public long[] BIT;
    public int n;

    public BinaryIndexedTree(long[] inputArray) {
        this.array = inputArray;

        n = inputArray.length;
        BIT = new long[n + 1];
        for (int i = 0; i < n; i++)
            init(i, inputArray[i]);
    }

    public void init(int i, long val) {
        i++;
        while (i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    void update(int index, long val) {
        long diff = val - array[index];
        array[index] = val;
        init(index, diff);
    }

    public long getSum(int index) {
        long sum = 0;
        index++;
        while (index > 0) {
            sum += BIT[index];
            index -= (index & -index);
        }
        return sum;
    }

    public long sumRange(int start, int end) {
        return getSum(end) - getSum(start - 1);
    }
}

public class Test {
    public static void main(String[] xps){
        long[] array = {1,2,3,4,5,6,7,8,9,10};
        BinaryIndexedTree binaryIndexedTree =new BinaryIndexedTree(array);
        System.out.println(binaryIndexedTree.sumRange(0,9));

        //Output : 55

        binaryIndexedTree.update(9,20);
        System.out.println(binaryIndexedTree.sumRange(0,9));

        //Output : 65

        long[] array2 = {100000000000L, 230000000000L, 20002403020022L, 4054939292922L};
        BinaryIndexedTree binaryIndexedTree1 = new BinaryIndexedTree(array2);
        System.out.println(binaryIndexedTree1.sumRange(0,1));

        //Output : 330000000000
    }
}
