package practice;

public class RemovedDuplicateSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i;
        for (i=0; i < nums.length; i++) {
            if (!(i == nums.length - 1) && nums[i] == nums[i + 1]) {
                nums = shiftArray(nums, i);
                if (nums[i] == nums[nums.length - 1]) {
                    return i + 1;
                }
                i--;
            }
        }
        return i;
    }

    private static int[] shiftArray(int[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            if (j == nums.length - 1) {
                break;
            }
            nums[j] = nums[j + 1];
        }
        return nums;
    }
}
