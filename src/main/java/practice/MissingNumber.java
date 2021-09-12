package practice;

public class MissingNumber {
    public static void main(String[] args) {
        int[] num = new int[]{3,0,1};
        System.out.println(missingNumber(num));
    }

    private static int missingNumber(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[0]+=nums[i];
        }
        return ((nums.length*(1+nums.length))/2) - nums[0];
    }
}
