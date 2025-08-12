class Solution {
    public int findCircleNum(int[][] iscon) {
        int count = 0 ;
        int[] arr=new int[iscon.length];
        for(int i=0;i<iscon.length;i++){
            if(arr[i]==1) continue;
            count++;
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            arr[i]=1;
            while(!q.isEmpty()){
                int n=q.poll();
                
                for(int j=0;j<iscon.length;j++){
                    if(n==j) continue;
                    if(iscon[n][j]==1 && arr[j]==0) {
                        q.offer(j);
                        arr[j]=1;
                    }
                }
            }
        }
        return count;
    }
}