// Breadth-First Search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;;
class graph_2{

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
    //    graph[0].add(new Edge(0, 3, 0));
       graph[0].add(new Edge(0, 4, 0));


       graph[1].add(new Edge(1, 0, 0));
       graph[1].add(new Edge(1, 3, 0));


       graph[2].add(new Edge(2, 0, 0));
       graph[2].add(new Edge(2, 3, 0));
       graph[2].add(new Edge(2, 4, 0));

    //    graph[3].add(new Edge(3, 0, 0));
       graph[3].add(new Edge(3, 1, 0));
       graph[3].add(new Edge(3, 2, 0));

       graph[4].add(new Edge(4, 0, 0));
       graph[4].add(new Edge(4, 2, 0));
       
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

    public static void bfs(ArrayList<Edge> graph[],boolean[] vis,Queue<Integer> q){

     while(!q.isEmpty()){
      int curr = q.remove();
      if(!vis[curr]){
      vis[curr] = true;
      System.out.println(curr + "bfs ");
      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        int neigh = e.dest;
          if(!vis[neigh]){
        //    System.out.println(neigh+" " + curr);
           q.add(neigh);
          }
      }
    }  
    }

    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Breadth-First Search
 
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();



        for(int i=0;i<V;i++){
            if(!vis[i]){
            q.add(i);
            bfs(graph,vis,q);
        }
        }
       System.out.println();
        
    }
}