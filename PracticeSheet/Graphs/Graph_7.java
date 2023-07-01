package PracticeSheet.Graphs;
import java.util.*;
public class Graph_7 {
    public static void main(String[] args) {
        int N = 6;
                int[] KnightPos = {6,6};
                int[] TargetPos = {1,1};
                Solution obj = new Solution();
                int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
                System.out.println(ans);
    }

static class Solution
{
    public boolean vaid(int x,int y,int n){
        if(x>=0 && y>=0 && x<n && y<n )
        return true;
        return false;
    }
    public void help(int x,int y,int[][] dist,Queue<int[]> que,int[] TargetPos,int N){
        int [] p={-2,-2,-1,-1,1,1,2,2};
        int [] q={-1,1,2,-2,2,-2,1,-1};
        for(int i=0;i<p.length;i++){
            // if(vaid(x+p[i],y+q[i],N)){
            // System.out.println("point added to queue for x and y " + x +"----"+ y +" dist[x][y] "+ dist[x][y]);
            // System.out.println("---------------------------------"+ (x+p[i])+"----"+(y+q[i])+"---old dist loop " + dist[x+p[i]][y+q[i]]);
            // }
            if(vaid(x+p[i],y+q[i],N) && dist[x+p[i]][y+q[i]]>dist[x][y]+1){
                dist[x+p[i]][y+q[i]]=dist[x][y]+1;
                int[] points={x+p[i],y+q[i]};
                // System.out.println("---------------------------------"+points[0]+"----------"+points[1]+"---new dist  " + dist[x+p[i]][y+q[i]]);
                // System.out.println();
                que.add(points);
                if(TargetPos[0]-1==x+p[i] && TargetPos[1]-1==y+q[i]){
                    // System.out.println("found");
                    // System.out.println();
                    // System.out.println();
                    // System.out.println();
                    // System.out.println();
                    return;
                }
            }
        }
        
    }
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1])
        return 0;
        if(KnightPos[0]>N || TargetPos[0]>N || 
        KnightPos[1]>N || TargetPos[1]>N || 
        KnightPos[0]<1 || TargetPos[0]<1 || 
        KnightPos[1]<1 || TargetPos[1]<1)
        return -1;
        
         int[][] dist=new int[N][N];
         Queue<int[]> que=new LinkedList<>();
         for(int i=0;i<N;i++){
             for(int j=0;j<N;j++){
                 dist[i][j]=Integer.MAX_VALUE;
             }
         }
         dist[KnightPos[0]-1][KnightPos[1]-1]=0;
         int[] p={KnightPos[0]-1,KnightPos[1]-1};
         
         que.add(p);
         while(!que.isEmpty()){
             int[] point=que.poll();
             int x=point[0];
             int y=point[1];
             help(x,y,dist,que,TargetPos,N);
             
         }
         return dist[TargetPos[0]-1][TargetPos[1]-1];
    }
}
}
