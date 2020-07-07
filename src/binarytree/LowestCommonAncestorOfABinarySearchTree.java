package binarytree;

/**
 * @author Tosca
 * @date 3/7/2020
 */

/* leetcode 235 / 236 */
public class LowestCommonAncestorOfABinarySearchTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 如果当前的 根节点 为p或者q的话，那么当前根节点就为他们的公共祖先
    if (root == null || root == p || root == q) return root;
    // 找到左子树的节点（null or p pr q）
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    // 找右子树的节点
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //
    return left == null ? right : right == null ? left : root;
  }
}
