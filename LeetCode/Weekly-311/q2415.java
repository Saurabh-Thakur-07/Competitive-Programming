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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)
            return null;
        ArrayList<ArrayList<TreeNode>> li = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty())
        {
            ArrayList<TreeNode> t = new ArrayList<>();
            int size=q.size();
            while(size-->0)
            {
                TreeNode top = q.remove();
                t.add(top);
                if(top.left!= null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
            }
            li.add(t);
        }
        if(li.size()==1)
            return root;
        for(int i=1;i<li.size();i+=2)
        {
            int k1=0,k2=li.get(i).size()-1;
            while(k1<k2)
            {
                int tval = li.get(i).get(k1).val;
                li.get(i).get(k1).val = li.get(i).get(k2).val;
                li.get(i).get(k2).val = tval;
                k1++;
                k2--;
            }
            // System.out.println();
        }
        return root;
    }
}
