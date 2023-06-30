//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t-- > 0) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                int V = sc.nextInt();
                int E = sc.nextInt();
                for (int i = 0; i < V; i++)
                    list.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    list.get(u).add(v);
                }
                if (new Solution().isCyclic(V, list) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    
    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            boolean[] vis=new boolean[V];
            boolean[] rec_stack=new boolean[V];
            ArrayList<Integer> result = new ArrayList<Integer>();
            for(int i=0;i<V;i++){
                if(!vis[i]){
                if(dfs(adj,vis,i,rec_stack)){
                    return true;
                }
            }
            }
            return false;
        }
        public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int curr,boolean[] rec_stack){
            
            vis[curr]=true;
            rec_stack[curr]=true;
             for(int i=0;i<adj.get(curr).size();i++){
                    int neigh = adj.get(curr).get(i);
                    if(rec_stack[neigh]){
                        return true;
                    }
                    if(!vis[neigh]){
                        if(dfs(adj,vis,neigh,rec_stack)){
                            return true;
                        }
                    }
                }
            rec_stack[curr]=false;
            return false;
        }
    }