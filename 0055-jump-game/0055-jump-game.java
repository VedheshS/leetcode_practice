class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        int c=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0||nums[i]<=c) {
                if(nums[i]+i==nums.length-1) c=0;
                else c++;
            }
            else{
                c=0;
            }
        }
        return c==0;
    }
}