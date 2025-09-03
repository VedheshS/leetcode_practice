class Solution {
    public int[][] updateMatrix(int[][] arr) {
        int one=0;
        int r=arr.length;
        int c=arr[0].length;
        int t=r+c+1;
        int[][] hlp=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]!=0){
                    one++;
                    hlp[i][j]=t;
                }
            }
        }
        int a=1;
        while(one>0){
            int[][] h=new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++) h[i][j]=hlp[i][j];
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(hlp[i][j]==0){
                        if(i>0&& hlp[i-1][j]==t&&h[i-1][j]==t){
                            h[i-1][j]=0;
                            arr[i-1][j]=a;
                            one--;
                        }
                        if(i<r-1&&hlp[i+1][j]==t&&h[i+1][j]==t){
                            one--;
                            h[i+1][j]=0;
                            arr[i+1][j]=a;
                        }
                        if(j>0&&hlp[i][j-1]==t&&h[i][j-1]==t){
                            one--;
                            h[i][j-1]=0;
                            arr[i][j-1]=a;
                        }
                        if(j<c-1&&hlp[i][j+1]==t&&h[i][j+1]==t){
                            one--;
                            h[i][j+1]=0;
                            arr[i][j+1]=a;
                        }
                    }
                }
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++) hlp[i][j]=h[i][j];
            }
            a++;
        }
        return arr;
    }
}