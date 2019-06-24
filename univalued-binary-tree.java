/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return testUniVal(root, root.val);
    }
    public boolean testUniVal(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        else if (root.val != value) {
            return false;
        }
        else {
            boolean leftUniVal = testUniVal(root.left, value);
            boolean rightUniVal = testUniVal(root.right, value);
            if (leftUniVal == false || rightUniVal == false) {
                return false;
            }
            else {
                return true;
            }
        }
    }
}
