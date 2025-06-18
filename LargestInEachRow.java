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

 // Time complexity - O(n)
 // Space complexity - O(n)
 // DID you solve on leetcode - yes
 // Did you face any issues - no
 // The algorithm performs a level-order traversal (BFS) of the binary tree using a queue to process nodes level by level. At each level, it iterates through all nodes, tracking the maximum value found among them. After processing a level, it adds the maximum value to the result list and continues until all levels are traversed.
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(node.val>max) 
                max = node.val;

                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }

            result.add(max);
        }
        return result;
    }
}
