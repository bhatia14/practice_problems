package practice;

import java.util.SortedMap;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int n: nums) {
            treeSet.add(n);
        }
        int count=0;
        for (Integer i: treeSet){
            count += Math.abs(i);
        }
        int sol=0;
        for (Integer i: treeSet){
            if(count-i <= treeSet.size()){
                sol++;
            }
        }
        return sol;
    }
}
