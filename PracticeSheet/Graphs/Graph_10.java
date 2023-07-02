package PracticeSheet.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph_10 {

    public static void main(String[] args) {
        int n = 6;
        int[][] connections    = {{0,1},{0,2},{0,3},{1,2}};
        
        Solution obj = new Solution();
        int ans = obj.makeConnected(n,connections );
        System.out.println(ans);
    }
    static class Solution {
        public static int dfs(ArrayList<Integer> con[],boolean[] vis,int curr,int par){
            int w=0;
            vis[curr]=true;
            for(int i =0;i<con[curr].size() ; i++){
                int dest = con[curr].get(i) ;
                if(vis[dest] && dest!=par){
                    w++;
                }
                if(!vis[dest]){
                    w+= dfs(con,vis,dest,curr);
                }
            }
            return w;
        }
        public int makeConnected(int n, int[][] connections) {
            
        ArrayList<Integer> graph[] = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<connections.length;i++){
            int[] con = connections[i];
            int src  = con[0];
            int dest = con[1];
            graph[src].add(dest);
            graph[dest].add(src);
        }

            boolean[] vis = new boolean[n];
            int numberOfUnconnected = 0; 
            int numberOfRemoveableWires = 0;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    numberOfRemoveableWires += dfs(graph,vis, i,-1); 
                    numberOfUnconnected++;
                }
            }
            
            numberOfRemoveableWires = numberOfRemoveableWires / 2;
            if(numberOfRemoveableWires<numberOfUnconnected-1){
                return -1;
            }else{
                return numberOfUnconnected-1;
            }

            
        }
}
}