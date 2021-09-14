package practice;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        }
        return rHeight + 1;
    }

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
