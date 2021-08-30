package practice;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(39));
    }

    private static int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int temp = 1;
        int temp_1 = 1;
        for (int i = 2; i <= n; i++) {
            int tempx = temp;
            temp += temp_1;
            temp_1 = tempx;
        }

        return temp;
    }
}
