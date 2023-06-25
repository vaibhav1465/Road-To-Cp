import java.util.ArrayList;
public class Algorithm_5 {
    static class Edge {
        int dest;
        int src;
        int wt;
        public Edge(int s,int d,int w){
            this.src  = s;
            this.dest = d;
            this.wt   = w;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
       }

       graph[0].add(new Edge(0, 1, 0));
       graph[0].add(new Edge(0, 2, 0));
       graph[0].add(new Edge(0, 3, 0));
    //    graph[0].add(new Edge(0, 4, 0));


       graph[1].add(new Edge(1, 0, 0));
       graph[1].add(new Edge(1, 2, 0));


       graph[2].add(new Edge(2, 0, 0));
       graph[2].add(new Edge(2, 1, 0));
    //    graph[2].add(new Edge(2, 4, 0));

       graph[3].add(new Edge(3, 0, 0));
       graph[3].add(new Edge(3, 4, 0));
    //    graph[3].add(new Edge(3, 5, 0));

       graph[4].add(new Edge(4, 3, 0));
    //    graph[4].add(new Edge(4, 5, 0));

    //    graph[5].add(new Edge(5, 3, 0));
    //    graph[5].add(new Edge(5, 4, 0));

       
    }
 

    public static void printGraph(ArrayList<Edge> graph[]){

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int dest = e.dest;
                int src  = e.src;
                System.out.println("Edge------------"+src+"---------->"+dest  );
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,int par,boolean[] vis,int[] dist,int[] low,int time){
 
        vis[curr] = true;
        dist[curr]=low[curr]=++time;
        // System.out.println(par+"------>----"+curr+" time--> "+time);
        // System.out.println("dt of current ->  "+dist[curr]+" low of current -> "+low[curr]);
        // System.out.println();

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(!vis[neigh]){
              dfs(graph, neigh,curr, vis,dist,low,time);
              low[curr]=Math.min(low[curr], low[neigh]);
            //   System.out.println("Backtracting  curr  - > " + curr + " neigh ---> "+ neigh);
            //   System.out.println("dt of current ->  "+dist[curr]+" low of neigh -> "+low[neigh]);
            //   System.out.println();

              if(dist[curr]<low[neigh]){
               System.out.println("Bridge Found --------"+curr+"---> "+neigh);
              }
            }else if(vis[neigh] && neigh!=par){
            //   System.out.println("Back Edge curr  - > " + curr + " neigh ---> "+ neigh);
            //   System.out.println("low of current ->  "+low[curr]+" dt of neigh -> "+dist[neigh]);
            //   System.out.println();

              low[curr]=Math.min(low[curr], dist[neigh]);
            }

        }

    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Tarzan Algorithm
 
        boolean[] vis = new boolean[V];
        int[] dist    = new int[V];
        int[] low    = new int[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
            dfs(graph,i,-1,vis,dist,low,0);
        }
        }
       System.out.println();
        
    }

}

