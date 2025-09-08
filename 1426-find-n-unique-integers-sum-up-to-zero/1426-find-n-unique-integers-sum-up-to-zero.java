class Solution {
    public int[] sumZero(int n) {
        int sum=0;
        int[] arr=new int[n];
        for(int i=0;i<n-1;i++){
            arr[i]=i+1;
            sum+=arr[i];
        }
        arr[n-1]=-1*(sum);
        return arr;
    }
}