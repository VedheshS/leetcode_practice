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
    public int maxLevelSum(TreeNode root) {
        int level=1;
        int l=1;
        int sum=0;
        int max=root.val;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode t=new TreeNode(1);
        q.offer(t);
        while(q.size()!=1){
            TreeNode temp=q.poll();
            if(temp.equals(t)){
                q.offer(t);
                if(max<sum){
                    max=sum;
                    level=l;
                }
                l++;
                sum=0;
                continue;
            }
            else{
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null) q.offer(temp.right);
            }
            sum+=temp.val;
        }
        if(sum>max) level=l;
        return level;
    }
}