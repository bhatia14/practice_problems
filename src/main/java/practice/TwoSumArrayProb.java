package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumArrayProb {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, -3, -4, -5};

        System.out.println(twoSum(nums, -8));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
//            if(target >= nums[i]) {
            if (hashMap.containsKey(nums[i])) {
                ArrayList<Integer> a = hashMap.get(nums[i]);
                a.add(i);
                hashMap.put(nums[i], a);
            } else {
                ArrayList<Integer> b = new ArrayList<Integer>();
                b.add(i);
                hashMap.put(nums[i], b);
            }
            //}
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(temp)) {

                List<Integer> tempList = hashMap.get(temp);
                if (tempList.size() > 1) {
                    result[0] = tempList.get(0);
                    result[1] = tempList.get(1);
                } else {
                    result[0] = tempList.get(0);
                    result[1] = i;
                }

            }
        }
        return result;
    }
}
