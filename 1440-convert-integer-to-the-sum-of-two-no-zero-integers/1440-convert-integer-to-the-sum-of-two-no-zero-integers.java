class Solution {
    public int[] getNoZeroIntegers(int n) {
        int diff=0;
        int tem=1;
        int h=n;
        while(h>0){
            int t=h%10;
            if(t!=1){
                h-=1;
                diff=tem+diff;
            }
            else{
                if(h/10!=0){
                    h-=2;
                    diff=(tem*2)+diff;
                }
            }
            tem*=10;
            h/=10;
        }
        return new int[]{diff,n-diff};
    }
}