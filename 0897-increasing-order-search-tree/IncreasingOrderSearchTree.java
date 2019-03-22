import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        inorder(root, queue);
        TreeNode newRoot = null;
        if (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
            newRoot = new TreeNode(peek.val);
        }
        TreeNode point = newRoot;
        while (!queue.isEmpty()) {
            point.right = new TreeNode(queue.poll().val);
            point = point.right;
        }
        return newRoot;
    }

    private void inorder(TreeNode treeNode, Queue<TreeNode> queue) {
        if (treeNode == null) return;
        inorder(treeNode.left, queue);
        queue.add(treeNode);
        inorder(treeNode.right, queue);
    }

    public static void main(String[] args) {

    }
}