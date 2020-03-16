class BinaryIndexedTree {

    public int[] array;
    public int[] BIT;
    public int n;

    public BinaryIndexedTree(int[] inputArray) {
        this.array = inputArray;

        n = inputArray.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++)
            init(i, inputArray[i]);
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    void update(int index, int val) {
        int diff = val - array[index];
        array[index] = val;
        init(index, diff);
    }

    public int getSum(int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += BIT[index];
            index -= (index & -index);
        }
        return sum;
    }

    public int sumRange(int start, int end) {
        return getSum(end) - getSum(start - 1);
    }
}

public class Main2 {
    public static void main(String[] xps){
        int[] array={1,2,3,4,5,6,7,8,9,10};
        BinaryIndexedTree binaryIndexedTree =new BinaryIndexedTree(array);
        System.out.println(binaryIndexedTree.sumRange(0,9));

        //Output : 55

        binaryIndexedTree.update(9,20);
        System.out.println(binaryIndexedTree.sumRange(0,9));

        //Output : 65
    }
}
