package practice;

public class LowestCommonAncestorOfBST2 {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(5);
//        treeNode.left = new TreeNode(3);
//        treeNode.right = new TreeNode(6);
//        treeNode.left.left = new TreeNode(2);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.left.left.left = new TreeNode(1);

        TreeNode treeNode = new TreeNode(6);
        treeNode.left=new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);
        treeNode.left.right.left = new TreeNode(3);
        treeNode.left.right.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);

        TreeNode x = lowestCommonAncestor(treeNode, p, q);
        System.out.println(x);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root!= null){
            if(root.val > p.val && root.val > q.val) {
               return lowestCommonAncestor(root.left,p,q);
            }
            else if(root.val < p.val && root.val < q.val) {
              return   lowestCommonAncestor(root.right,p,q);
            }
            return root;
        }
        return null;
    }
}
