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
    class pair
    {
        TreeNode node;
        int nc;
        int par;
        public pair(TreeNode node,int nc,int par)
        {
            this.node=node;
            this.par=par;
            this.nc=nc;
        }
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<pair> pq = new ArrayDeque<>();
        int c=1;
        pq.add(new pair(root,0,-1));
        while(pq.size()>0)
        {
            int sz = pq.size();
            HashMap<Integer,Long> map = new HashMap<>();
            ArrayList<pair> arr = new ArrayList<>();
            long sum = 0;
            while(sz-- > 0)
            {
                pair rem = pq.remove();
                arr.add(rem);
                int nval = rem.nc;
                int parval = rem.par;
                TreeNode node = rem.node;
                int nodeval = node.val;
                sum += nodeval;
                map.put(parval,map.getOrDefault(parval,0l)+nodeval);
                // System.out.print(parval + " "+ nodeval+" ");
                if(node.left != null)
                {
                    pq.add(new pair(node.left,c++,nval));
                }
                if(node.right != null)
                {
                    pq.add(new pair(node.right,c++,nval));
                }
            }
            // System.out.println();
            for(int i=0;i<arr.size();i++)
            {
                pair rem = arr.get(i);
                int parval = rem.par;
                TreeNode node = rem.node;
                int nodeval = node.val;
                long v = map.get(parval);
                // System.out.print(sum+" "+v+" ");
                node.val = (int)(sum - v);
            }
            // System.out.println();
        }
        return root;
    }
}
