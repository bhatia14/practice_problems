package practice;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorTravesal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left =new TreeNode(20);
        root.right =new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.left = new TreeNode(80);


        //InorderTraversal.TreeNode root = new InorderTraversal.TreeNode(1, null, new InorderTraversal.TreeNode(2, new InorderTraversal.TreeNode(3), null));

        inorderTraversal(root);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(root != null) {
            inOrder(root, list, 40);
        }
        return list;
    }

    private static void inOrder(TreeNode root, List<Integer> list, int target){

        if(root.left != null) {
            inOrder(root.left, list, target);

        }

        if(list.get(list.size()-1) == target) {
            list.add(root.val);
            list.add(-100);
        }
        if(list.get(list.size()-1) != -100) {
            list.add(root.val);
        }
        if(root.right != null) {
            inOrder(root.right, list, target);
        }

    }

}
