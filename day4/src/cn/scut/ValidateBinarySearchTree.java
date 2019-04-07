package cn.scut;

import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBinarySearchTree {


    /**
     * 判断一棵二叉树是不是合法的二叉搜索树
     * 思路
     * 1) 先中序遍历二叉树
     * 2) 两两元素比较是否有逆序的情况发生
     * version_1
     * @param root
     * @return
     */
    public static boolean isValidBST_v1(TreeNode root) {
        List<Integer> vallist = new ArrayList<>();
        DFS(root, vallist);

        for (int i = 0; i < vallist.size() - 1; i++) {
            if (vallist.get(i) >= vallist.get(i + 1)) {
                return false;
            }
        }


        return true;
    }

    public static void DFS(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        DFS(root.left, list);
        list.add(root.val);
        DFS(root.right, list);
    }


    /**
     * root : 取值范围[-inf, inf]
     * root的左子树: [-inf, root.val]
     * root的右子树: [root.val, inf]
     *
     * faster than 100%
     * version_2
     * @param root
     * @return
     */
    public static boolean isValidBST_v2(TreeNode root) {
        if (root == null)
            return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= high)
            return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }




    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;


//        TreeNode root = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node6 = new TreeNode(6);
//        root.left = node1;
//        root.right = node4;
//        node4.left = node3;
//        node4.right = node6;

        System.out.println(isValidBST_v2(root));

    }
}
