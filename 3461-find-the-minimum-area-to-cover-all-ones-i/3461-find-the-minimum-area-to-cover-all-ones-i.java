class Solution {
    public int minimumArea(int[][] arr) {
        int imin=arr.length,imax=-1;
        int jmin=arr.length,jmax=-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    imin=Math.min(imin,i);
                    imax=Math.max(imax,i);
                    jmin=Math.min(jmin,j);
                    jmax=Math.max(jmax,j);
                }
            }
        }
        return (imax-imin+1)*(jmax-jmin+1);
    }
}