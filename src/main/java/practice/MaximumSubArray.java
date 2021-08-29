package practice;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    private static int maxSubArray(int[] nums) {
        int target = 0;
        int max_num_found = Integer.MIN_VALUE;
        for (int i = 0; i< nums.length;i++){
            target = target + nums[i];
            if(max_num_found < target) {
                max_num_found = target;
            }
            if(target < 0) {
                target = 0;
            }
        }
        return max_num_found;
    }
}
