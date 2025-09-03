class Solution {
    char[][] arr;
    int n;
    int q;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int len) {
        n=len;
        arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        q=0;
        ans=new ArrayList<>();
        itr(0);
        return ans;
    }
    void itr(int i){
        if(i>=n||i<0) return;
        int c=0;
        if(i<q){
            int a=0;
            q--;
            for(int j=0;j<n;j++){
                if(arr[i][j]=='Q') {
                    a=j;
                    arr[i][j]='.';
                }
            }
            for(int j=a+1;j<n;j++){
                boolean b=check(i,j);
                if(b){
                    arr[i][j]='Q';
                    q++;
                    c++;
                    break;
                }
            }
        }
        else{
            for(int j=0;j<n;j++){
                boolean b=check(i,j);
                if(b){
                    arr[i][j]='Q';
                    q++;
                    c++;
                    break;
                }
            }
        }
        if(c>0){
            itr(i+1);
            if(i==n-1){
                List<String> s=new ArrayList<>();
                for(int a=0;a<n;a++){
                    StringBuilder sb=new StringBuilder();
                    for(int b=0;b<n;b++){
                        sb.append(arr[a][b]);
                    }
                    s.add(sb.toString());
                }
                ans.add(s);
                itr(i);
            }
        }
        else itr(i-1);
    }
    boolean check(int i,int j){
        int a=i,b=j;
        while(a>0){
            a--;
            if(arr[a][b]=='Q') return false;
        }
        a=i;
        b=j;
        while(a>0&&b>0){
            a--;
            b--;
            if(arr[a][b]=='Q') return false;
        }
        a=i;
        b=j;
        while(a>0&&b<n-1){
            a--;
            b++;
            if(arr[a][b]=='Q') return false;
        }
        return true;
    }
}