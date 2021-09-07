package practice;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
//        TreeNode left2 = new TreeNode(3);
//
//        TreeNode right1 = new TreeNode(2);
//        right1.left = left2;
//
//        TreeNode root = new TreeNode(1);
//        root.right = right1;

        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));

        inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            inOrder(root, list);
        }
        return list;
    }

    private static void inOrder(TreeNode root, List<Integer> list){
        if(root.left != null) {
            inOrder(root.left, list);

        }
        list.add(root.val);
        if(root.right != null) {
            inOrder(root.right, list);
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
