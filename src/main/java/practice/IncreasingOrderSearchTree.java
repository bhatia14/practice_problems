package practice;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        increasingBST(treeNode);
    }

    private static TreeNode increasingBST(TreeNode root) {

        List<Integer> setTreeNode = new ArrayList<>();

        if (root != null) {
            inOrder(root, setTreeNode);
        }

        TreeNode treeNode = new TreeNode(setTreeNode.get(0));

        for (int i = 1; i < setTreeNode.size(); i++) {
            TreeNode child = new TreeNode(setTreeNode.get(i));
            createTree(treeNode, child);
        }

        return treeNode;
    }

    private static void createTree(TreeNode treeNode, TreeNode child) {
        if (treeNode.right != null) {
            createTree(treeNode.right, child);
        } else {
            treeNode.right = child;
        }
    }

    private static void inOrder(TreeNode root, List<Integer> set) {

        if (root.left != null) {
            inOrder(root.left, set);
        }
        set.add(root.val);
        if (root.right != null) {
            inOrder(root.right, set);
        }
    }


    // Definition for a binary tree node.
    public static class TreeNode {
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
