class node{
    int r;
    int c;
    node(int i,int j){
        r=i;
        c=j;
    }
}
class Solution {
    int rotten;
    int fresh;
    int[][] graph;
    Queue<node> q;
    
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        
        q=new LinkedList<>();
        
        graph=grid;
        rotten=0;
        fresh=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(graph[i][j]==1) fresh++;
                if(graph[i][j]==2) {
                    rotten++;
                    q.offer(new node(i,j));
                }
            }
        }
        
        if(fresh==0) return 0;
        if(rotten==0) return -1;

        node t=new node(-1,-1);
        
        q.offer(t);
        int cn=0,h=0;

        while(q.size()>1){
            node n=q.poll();
            if(n==t){
                q.offer(t);
                if(h>0) cn++;
                h=0;
                continue;
            }
            if(check(n)) h++;
        }
        if(fresh>0) return -1;
        if(h>0) cn++;
        return cn;
    }
    boolean check(node n){
        int i=n.r;
        int j=n.c;
        int c=0;
        if(i>0 && graph[i-1][j]==1){
            q.offer(new node(i-1,j));
            graph[i-1][j]=2;
            fresh--;
            c++;
        }
        if(i<graph.length-1 && graph[i+1][j]==1){
            q.offer(new node(i+1,j));
            graph[i+1][j]=2;
            fresh--;
            c++;
        }
        if(j>0 && graph[i][j-1]==1){
            q.offer(new node(i,j-1));
            graph[i][j-1]=2;
            fresh--;
            c++;
        }
        if(j<graph[0].length-1 && graph[i][j+1]==1){
            q.offer(new node(i,j+1));
            graph[i][j+1]=2;
            fresh--;
            c++;
        }
        return c>0;
    }
}