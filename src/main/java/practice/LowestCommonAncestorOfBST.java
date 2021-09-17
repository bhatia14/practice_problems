package practice;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class LowestCommonAncestorOfBST {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(6);
//        treeNode.left=new TreeNode(2);
//        treeNode.right = new TreeNode(8);
//        treeNode.left.left = new TreeNode(0);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.right.left = new TreeNode(7);
//        treeNode.right.right = new TreeNode(9);
//        treeNode.left.right.left = new TreeNode(3);
//        treeNode.left.right.right = new TreeNode(5);

//        TreeNode treeNode = new TreeNode(3);
//        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(4);
//        treeNode.left.right = new TreeNode(2);

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);

        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(3);

        TreeNode x = lowestCommonAncestor(treeNode, p, q);
        System.out.println(x.val);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> map = new HashMap<>();

        lCACalculator(root, null, p, q, map);
        if (map.size() == 2) {
            if(map.get(p.val)== null || map.get(q.val) == null){
                return root;
            }
            if (map.get(p.val).val == map.get(q.val).val) {
                return map.entrySet().iterator().next().getValue();
            } else {
                AtomicReference<Integer> pair1 = new AtomicReference<>(0);
                map.forEach((integer, treeNode) -> {
                   pair1.set(integer);
                });

        return p.val == pair1.get() ? p : q;
                //return pair1.get();
            }
        }
        return null;
    }

    private static void lCACalculator(TreeNode root,
                                      TreeNode rootOfRoot,
                                      TreeNode p,
                                      TreeNode q,
                                      HashMap<Integer, TreeNode> map) {
        if (root != null) {
            if (root.left != null) {
                lCACalculator(root.left, root, p, q, map);

            }
            if (root.val == p.val || root.val == q.val) {
                map.put(root.val, rootOfRoot);
            }
            if (root.right != null) {
                lCACalculator(root.right, root, p, q, map);
            }
        }
    }


//    private static TreeNode lCACalculator(TreeNode root, TreeNode p, TreeNode q){
//        if(root!=null) {
//            if (root.val == p.val) {
//                if (root.left != null && root.left.val == q.val) {
//                    return root;
//                }
//                if(root.right != null && root.right.val == q.val) {
//                    return root;
//                }
//            }
//            if (root.val == q.val) {
//                if (root.left != null && root.left.val == p.val) {
//                    return root;
//                }
//                if (root.right != null && root.right.val == p.val) {
//                    return root;
//                }
//            }
//            if (root.left != null && root.left.val == p.val){
//                if(root.right != null && root.right.val == q.val){
//                    return root;
//                }
//            }
//
//            if (root.left != null && root.left.val == q.val){
//                if(root.right != null && root.right.val == p.val){
//                    return root;
//                }
//            }
//
//            if (root.right != null && root.right.val == p.val){
//                if(root.left != null && root.left.val == q.val){
//                    return root;
//                }
//            }
//
//            if (root.right != null && root.right.val == q.val){
//                if(root.left != null && root.left.val == p.val){
//                    return root;
//                }
//            }
//
//            TreeNode val = lCACalculator(root.left, p, q);
//            if(val!= null){
//                return  val;
//            }
//            TreeNode val2 = lCACalculator(root.right, p, q);
//            if(val2!= null){
//                return  val2;
//            }
//            return null;
//        }
//        return null;
//    }

}
