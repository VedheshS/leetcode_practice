class Solution {
    public int areaOfMaxDiagonal(int[][] dim) {
        int max=0,diag=0;
        for(int i=0;i<dim.length;i++){
            int l=dim[i][0];
            int r=dim[i][1];
            int h=l*l + r*r;
            if(h>diag||(h==diag&&l*r>max)){
                diag=h;
                max=l*r;
            }
        }
        return max;
    }
}