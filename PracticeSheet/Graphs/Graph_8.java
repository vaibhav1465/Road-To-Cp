package PracticeSheet.Graphs;
import java.util.*;
public class Graph_8 {
    public static void main(String[] args) {
        int N = 2;
                int[][] m = {{0,0,0},
                             {0,0,0}};
                Solution obj = new Solution();
                int[][] ans = obj.floodFill(m,1,0 , 2);
                for(int i=0;i<N;i++){
                 for(int j=0;j<ans[i].length;j++){
                    System.out.print(ans[i][j]+" ");
                 }
                 System.out.println();
                }

    }
    static class Solution {
   
        public boolean vaid(int x,int y,int[][] image){
            System.out.println(x+"  ----------  "+y);
            int n=image.length;
            int m;
            try{
            m=image[x].length;
            }catch(Exception e){
             return false;
           }
             if(x>=0 && y>=0 && x<n && y<m){
                System.out.println("passed");
             return true;
             }
             return false;
         }
         public int[][] floodFill(int[][] image, int sr, int sc, int color) {
             
             int m = image.length;
             int[][] result = new int[m][];
             boolean[][] vis = new boolean[m][];
             for(int i=0;i<m;i++){
               result[i] = new int[image[i].length];
               vis[i]    = new boolean[image[i].length];
             }
             for(int i=0;i<m;i++){
                for(int j=0;j<image[i].length;j++){
                    result[i][j]=image[i][j];
                }
             }
            Queue<int[]> que=new LinkedList<>();
             int [] p={-1,0,1,0};
             int [] q={0,1,0,-1};class Solution {
   
                public boolean vaid(int x,int y,int[][] image){
                     int n=image.length;
                     int m;
                     try{
                     m=image[x].length;
                     }catch(Exception e){
                       return false;
                     }
                     if(x>=0 && y>=0 && x<n && y<m)
                     return true;
                     return false;
                 }
                 public int[][] floodFill(int[][] image, int sr, int sc, int color) {
                     
                     int m = image.length;
                     int[][] result = new int[m][];
                     boolean[][] vis = new boolean[m][];
                     for(int i=0;i<m;i++){
                       result[i] = new int[image[i].length];
                       vis[i]    = new boolean[image[i].length];
                     }
                     for(int i=0;i<m;i++){
                             for(int j=0;j<image[i].length;j++){
                                 result[i][j]=image[i][j];
                             }
                          }
             
                    Queue<int[]> que=new LinkedList<>();
                     int [] p={-1,0,1,0};
                     int [] q={0,1,0,-1};
                     int old_color = image[sr][sc];
                     int[] src_points={sr,sc};
                     que.add(src_points);
                    while(!que.isEmpty()){
                          int[] point=que.poll();
                          int x=point[0];
                          int y=point[1];
                          vis[x][y]=true;
                          result[x][y]=color;
                     for(int i=0;i<p.length;i++){
                         if(vaid(x+p[i],y+q[i],image) && image[x+p[i]][y+q[i]] == old_color && !vis[x+p[i]][y+q[i]]){
                           int[] points={x+p[i],y+q[i]};
                           que.add(points);
                         }
                       }     
                      }
                   
                   return result;
             
                 }
             }
             int old_color = image[sr][sc];
             int[] src_points={sr,sc};
             que.add(src_points);
            while(!que.isEmpty()){
                  int[] point=que.poll();
                  int x=point[0];
                  int y=point[1];
                  vis[x][y]=true;
                  result[x][y]=color;
                  System.out.println("Queue remove point---------"+x+"----"+y);
             for(int i=0;i<p.length;i++){
                 if(vaid(x+p[i],y+q[i],image) && image[x+p[i]][y+q[i]] == old_color && !vis[x+p[i]][y+q[i]]){
                   int[] points={x+p[i],y+q[i]};
                   System.out.println("Queue added point---------"+points[0]+"----"+points[1]);
                   que.add(points);
                 }
                }
                 System.out.println();
                 System.out.println();    
              }
           
           return result;
     
         }
     }
}
