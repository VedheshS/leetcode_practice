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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode t=new TreeNode(1001);
        Stack<List<Integer>> st=new Stack<>();
        List<Integer> a=new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
        q.offer(t);
        while(q.size()>1){
            TreeNode h=q.poll();
            if(h==t) {
                st.push(a);
                a=new ArrayList<>();
                q.offer(t);
                continue;
            }
            a.add(h.val);
            if(h.left!=null) q.offer(h.left);
            if(h.right!=null) q.offer(h.right);
        }
        st.push(a);
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}