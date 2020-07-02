package binarytree;

/**
 * @author Tosca
 * @date 2/7/2020
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ValidateBinarySearchTree {
  List<Integer> list = new ArrayList<>();
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    traverse(root);
    for (int i = 0; i < list.size(); ++i) {
      if (i + 1 < list.size() && list.get(i) >= list.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  // #1 中序遍历
  private void traverse(TreeNode root) {
    if (root.left != null) {
      traverse(root.left);
    }
    list.add(root.val);
    if (root.right != null) {
      traverse(root.right);
    }
  }

  TreeNode prev = null;
  public boolean isValidBST2(TreeNode root) {
    return traverse2(root);
  }

  // #1 最坏的情况，O(N)的时间复杂度
  private boolean traverse2(TreeNode root) {
    // 空树，认为是真
    if (root == null) return true;
    // 左子树不是BST，返回false
    if (!traverse2(root.left)) return false;
    // 前驱节点初始化为空，当到叶子节点时，被赋值
    // 前驱节点值小于当前节点，则当前节点为右子树的前驱
    if (prev == null || prev.val < root.val) {
      prev = root;
    } else {
      return false;
    }
    return traverse2(root.right);
  }

  public boolean isValidBST3(TreeNode root) {
    return traverse2(root);
  }

  // #2 递归，利用搜索树性质
  private boolean traverse(TreeNode root, Integer lower, Integer upper) {
    // 当前节点为null，返回true
    if (root == null) return true;
    // 当前节点小于下界 (右子树)
    if (lower != null && root.val <= lower) return false;
    // 当前大于上界（左子树）
    if (upper != null && root.val >= upper) return false;

    return traverse(root.left, lower, root.val) && traverse(root.right, root.val, upper);
  }
}
