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
    static TreeSet<Integer> set ;
    public void collect(TreeNode root)
    {
        if(root==null)  return;
        collect(root.left);
        set.add(root.val);
        collect(root.right);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        set = new TreeSet<>();
        collect(root);
        List<List<Integer>> list = new ArrayList<>();
        for(int val:queries)
        {
            List<Integer> arr = new ArrayList<>();
            if(set.contains(val)==true)
            {
                arr.add(val);arr.add(val);
            }
            else
            {
                if(set.lower(val)!=null)
                {
                    arr.add(set.lower(val));
                }
                else
                {
                    arr.add(-1);
                }
                if(set.higher(val)!=null)
                {
                    arr.add(set.higher(val));
                }
                else
                {
                    arr.add(-1);
                }
            }
            list.add(arr);
        }
        return list;
    }
}
