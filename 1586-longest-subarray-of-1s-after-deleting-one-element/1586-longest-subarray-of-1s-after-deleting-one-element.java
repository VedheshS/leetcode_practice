class Solution {
    public int longestSubarray(int[] arr) {
        int[] hlp=new int[arr.length+1];
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                if(hlp[i]<=0) hlp[i+1]=hlp[i];
                hlp[i+1]--;
                c++;
            }
            else {
                if(hlp[i]>=0) hlp[i+1]=arr[i]+hlp[i];
                else hlp[i+1]=arr[i];
            }
        }
        if(c==0) return arr.length-1;
        int max=0,cur=0;
        for(int i=hlp.length-1;i>0;i--){
            if(hlp[i]<0){
                if(hlp[i]==-1) {
                    cur=cur+hlp[i-1];
                    max=Math.max(max,cur);
                }
                cur=0;
            }
            if(hlp[i]>0) cur=Math.max(cur,hlp[i]);
            max=Math.max(cur,max);
        }
        return max;
    }
}