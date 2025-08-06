class Solution {
    public int findCenter(int[][] edges) {
        // Map<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<edges.length;i++){
        //     hm.put(edges[i][0],hm.getOrDefault(edges[i][0],0)+1);
        //     hm.put(edges[i][1],hm.getOrDefault(edges[i][1],0)+1);
        // }
        // int ans=0,max=0;
        // for(Map.Entry<Integer,Integer> m:hm.entrySet()){
        //     if(m.getValue()>max){
        //         max=m.getValue();
        //         ans=m.getKey();
        //     }
        // }
        // return ans;
        int n = edges.length + 1;
        int num[] = new int[n + 1];
        for (int val[] : edges){
            num[val[0]]++;
            num[val[1]]++;
        }
        int center = 1;
        int max = num[1];
        for (int i = 2 ; i <= n ; i++){
            if(num[i] > max){
                max = num[i];
                center = i;
            }
        }
        return center;
    }
}