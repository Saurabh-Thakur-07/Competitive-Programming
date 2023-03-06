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
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> pq = new ArrayDeque<>();
        pq.add(root);
        while(pq.size()>0)
        {
            int sz = pq.size();
            long sum = 0;
            while(sz-- > 0)
            {
                TreeNode rem = pq.remove();
                sum += rem.val;
                if(rem.left != null)
                pq.add(rem.left);
                if(rem.right != null)
                pq.add(rem.right);
            }
            pq1.add(sum);
        }
        if(pq1.size() < k)
        return -1;
        long ans=0;
        while(k-- > 0)
        ans = pq1.remove();
        return ans;
    }
}
