package practice;

import java.util.TreeSet;

public class TwoSumUniquePairMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int target = 19;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i=0;i<mat.length;i++){
            for (int j=0;j< mat[0].length;j++){
                treeSet.add(mat[i][j]);
            }
        }
        System.out.println("Treeset: "+treeSet);

        for (int i: treeSet) {
            if(treeSet.contains(target-i)){
                System.out.println("["+i+","+(target-i)+"]");
            }
            else {
                continue;
            }
            if(i > (target/2-1)){
                break;
            }
        }
    }
}
