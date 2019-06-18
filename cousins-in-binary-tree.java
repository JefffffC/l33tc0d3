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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        int xDepth = getTargetDepth(root, x, y, 0);
        if (xDepth == 0) return false; // if the first target could not be found or was a sibling, return false
        int yDepth = getTargetDepth(root, y, x, 0);
        if (xDepth == yDepth)
            return true;
        else return false;
    }
    
    public int getTargetDepth(TreeNode root, int x, int y, int level) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) { // check for sibling
            if (root.left.val == x && root.right.val == y)
                return 0;
        }
        if (root.val == x) {
            return level;
        }
        int result = getTargetDepth(root.left, x, y, level + 1);
        if (result != 0) {
            return result;
        }
        result = getTargetDepth(root.right, x, y, level + 1);
        return result;
    }
}
