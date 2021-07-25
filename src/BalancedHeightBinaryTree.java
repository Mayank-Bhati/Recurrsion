public class BalancedHeightBinaryTree {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        int lh = height(root.left);
        int rh = height(root.right);
        if((lh - rh) > 1 || (rh - lh) > 1)
            return false;
        else
            return true;

    }
    static int height(TreeNode root){
        if(root == null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
