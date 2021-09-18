package practice;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        System.out.println(minEatingSpeed(piles, 823855818));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        int min = piles[0];
        int max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (min > piles[i]) {
                min = piles[i];
            }
            if (max < piles[i]) {
                max = piles[i];
            }
        }

        if(h == piles.length) {
            return max;
        }
        if(min == max) {
            min = 0;
        }
        int diff = max - min;


        //int k1 = 0;

        while (k <= h) {
            k=0;
            for (int i = 0; i < piles.length; i++) {
               // int q = diff - piles[i];
                double a =  ((double)piles[i])/diff;
                k += (int) Math.ceil(a) > 1? (int) Math.ceil(a) : 1;
            }
            diff--;
        }

        while (k <= h) {
            k=0;
            for (int i = 0; i < piles.length; i++) {
                // int q = diff - piles[i];
                double a =  ((double)piles[i])/diff;
                k += (int) Math.ceil(a) > 1? (int) Math.ceil(a) : 1;
            }
            diff--;
        }

        return diff+2;

    }
}
