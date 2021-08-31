package practice;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

    private static int maxArea(int[] height) {
        int target = 0;
        int i = 0, j = height.length - 1;
        while (i < height.length) {
            int temp;
            if (height[i] > height[j]) {
                temp = height[j] * (j - i);
                j--;
            } else {
                temp = height[i] * (j - i);
                i++;
            }
            if (target < temp) {
                target = temp;
            }
        }
        return target;
    }
}
