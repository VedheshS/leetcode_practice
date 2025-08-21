class Solution {
    public int countSquares(int[][] arr) {
        if(arr.length==0||arr[0].length==0) return 0;
        int row=arr.length;
        int col=arr[0].length;
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==1){
                    if(i>0&&j>0){
                        arr[i][j]=Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]))+1;
                    }
                    ans+=arr[i][j];
                }
            }
        }
        return ans;
    }
}