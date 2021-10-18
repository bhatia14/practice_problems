package practice;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{9,0,-2});
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] post = new int[nums.length];
        int[] sol = new int[nums.length];
//        if(nums[0] < 0){
//
//        }
//        else if(nums[0] == 0){
//            prefix[0] = 0;
//        }
//        else {
//            prefix[0] = 1;
//        }
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i]  = prefix[i-1]*nums[i];
        }
        post[nums.length -1] = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            post[i] = post[i+1]* nums[i];
        }
        for(int i=0;i< nums.length;i++){

            if(i-1<0){
                sol[i] = post[i+1];
            }
            else if(i+1== nums.length)
            {
                sol[i] = prefix[i-1];
            }
            else {
                sol[i] = prefix[i-1]* post[i+1];
            }

        }
        return sol;
    }
}
