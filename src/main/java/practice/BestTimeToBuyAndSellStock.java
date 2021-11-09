package practice;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 4 , 1}));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = 1000000;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else if (prices[i] - min >= max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
