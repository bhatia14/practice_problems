package practice;

public class RangeOfSum {
    static int l=0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10,
                new TreeNode(5, new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null,new TreeNode(18))
                );

        System.out.println(rangeSumBST(treeNode,7, 15));
    }


    public static int rangeSumBST(TreeNode root, int low, int high) {

        inOrder(root, low, high);
        return l;
    }

    private static void inOrder(TreeNode root, int low, int high){
        if(root.left != null) {
            inOrder(root.left, low, high);

        }
        if(root.val<= high && root.val>= low){
            l+=root.val;
        }
        if(root.right != null) {
            inOrder(root.right, low, high);
        }

    }
}
