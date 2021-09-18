package practice;

public class KokoEatingBananasBinarySearchSol {
    public static void main(String[] args) {
        int[] piles = new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        System.out.println(minEatingSpeed(piles, 823855818));
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 1000000000;

        int x;

        while (min<max){
            x=(max+min)/2;

            if(!canKokoEatInTime(piles, h, x)){
                min = x+1;
            }
            else {
                max=x;
            }
        }
        return min;
    }

    private static boolean canKokoEatInTime(int[] piles, int h, int k){
        int t=0;
        for (int i = 0; i < piles.length; i++) {
            t+=(piles[i]-1)/k+1;
        }
        return t<=h;
    }
}
