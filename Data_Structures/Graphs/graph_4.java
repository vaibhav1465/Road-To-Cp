import java.util.ArrayList;;

public class graph_4 {
    
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
       graph[0].add(new Edge(0, 3, 0));
       graph[0].add(new Edge(0, 6, 0));


       graph[1].add(new Edge(1, 0, 0));
       graph[1].add(new Edge(1, 2, 0));


       graph[2].add(new Edge(2, 1, 0));
       graph[2].add(new Edge(2, 4, 0));
       graph[2].add(new Edge(2, 5, 0));
    

       graph[3].add(new Edge(3, 0, 0));
       graph[3].add(new Edge(3, 4, 0));
    

       graph[4].add(new Edge(4, 2, 0));
       graph[4].add(new Edge(4, 3, 0));
       graph[4].add(new Edge(4, 5, 0));

       graph[5].add(new Edge(5, 2, 0));
       graph[5].add(new Edge(5, 4, 0));
       graph[5].add(new Edge(5, 6, 0));

       graph[6].add(new Edge(6, 0, 0));
       graph[6].add(new Edge(6, 5, 0));
       
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

    public static void all_paths(ArrayList<Edge> graph[],boolean[] vis,int curr,int dest,String path){

        if(curr==dest){
            System.out.println(path);
            return;
        }
  
        

        for(int i =0 ; i< graph[curr].size(); i++ ){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(!vis[neigh]){
                vis[curr] = true;
                all_paths(graph, vis, neigh, dest, path+neigh);
                vis[curr] = false;
            }
        }


    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // All Paths from Source to Destination
        boolean[] vis = new boolean[V];
        all_paths(graph,vis,0,5,"0");

       System.out.println();
        
    }

}
