package practice;

import java.util.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }

    private static int maxArea(int[] height) {
        int target = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i =0;i< height.length;i++){
            treeMap.put(height[i], i);
        }
        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        int x=0;
        int key=0;
        while (iterator.hasNext()){
            Map.Entry m = (Map.Entry) iterator.next();
            int tempKey = (int) m.getKey();

            if(x>0){
               int tempTarget =  tempKey * (Math.abs(treeMap.get(tempKey) - treeMap.get(key)));
               if(tempTarget> target){
                   target = tempTarget;
               }
            }
            x++;
            key = tempKey;

        }
        return target;
    }
}
