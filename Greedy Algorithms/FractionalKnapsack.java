/**
 * Fractional Knapsack Problem usi
 * Time complexity O(n log n)
  */
import java.util.Arrays;

public class Main {
    static class ItemValue {
        Double profitByWeightRatio;
        double weight, profit, index;

        public ItemValue(int weight, int profit, int index) {
            this.weight = weight;
            this.profit = profit;
            this.index = index;
            profitByWeightRatio = Double.valueOf(profit / weight);
        }
    }

    public static double getMaxValue(int[] weight, int[] value, int capacity) {
        ItemValue[] itemValue = new ItemValue[weight.length];

        for(int i = 0; i < weight.length; i++)
            itemValue[i] = new ItemValue(weight[i], value[i], i);

        //sorting items according to profit by weight ratio
        Arrays.sort(itemValue, (o1, o2) -> o2.profitByWeightRatio.compareTo(o1.profitByWeightRatio));

        double totalValue = 0d;

        for(ItemValue i: itemValue) {
            int curWt = (int) i.weight;
            int curVal = (int) i.profit;

            if (capacity - curWt >= 0) {
                // this weight can be picked
                capacity = capacity-curWt;
                totalValue += curVal;

            }
            else {
                // item cant be picked whole
                double fraction = ((double)capacity/(double)curWt);
                totalValue += (curVal*fraction);
                capacity = (int)(capacity - (curWt*fraction));
                break;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        int[] weight = {10, 40, 20, 30};
        int[] profit = {60, 40, 100, 120};
        int capacity = 50;

        double maxProfit = getMaxValue(weight, profit, capacity);
        System.out.println("Maximum value we can obtain = " +
                maxProfit);
    }
}
