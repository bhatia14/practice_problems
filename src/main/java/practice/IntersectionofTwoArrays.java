package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArrays {
    public static void main(String[] args) {

        System.out.println(intersect(new int[]{4, 5, 9}, new int[]{9, 4, 9, 8, 4}));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            List<Integer> list = new ArrayList();
            Map<Integer, Integer> map1 = getListOfMap(nums1);
            Map<Integer, Integer> map2 = getListOfMap(nums2);
            for (int i : nums2) {
                if (map1.containsKey(i)) {
                    list.add(i);
                }
            }
            int[] sol = listToIntArray(list);
            return sol;
        } else {
            Map<Integer, Integer> map = getListOfMap(nums2);
            List<Integer> list = new ArrayList();
            for (int i : nums1) {
                if (map.containsKey(i)) {
                    list.add(i);
                }
            }
            int[] sol = listToIntArray(list);
            return sol;
        }

    }


    private static int[] listToIntArray(List<Integer> list) {
        int[] sol = new int[list.size()];
        for (int i = 0 ;i< sol.length;i++){
            sol[i] = list.get(i);
        }
        return sol;
    }

    private static Map<Integer, Integer> getListOfMap(int[] nums1) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        return map;
    }
}
