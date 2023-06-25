import java.util.ArrayList;
public class graph_8 {
    
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

       graph[0].add(new Edge(0, 1, 2));
    //    graph[0].add(new Edge(0, 2, 0));
    //    graph[0].add(new Edge(0, 3, 0));
       graph[0].add(new Edge(0, 2, 4));


       graph[1].add(new Edge(1, 2, -4));
    //    graph[1].add(new Edge(1, 3, 0));


    //    graph[2].add(new Edge(2, 0, 0));
       graph[2].add(new Edge(2, 3, 2));
    //    graph[2].add(new Edge(2, 4, 0));

    //    graph[3].add(new Edge(3, 0, 0));
    //    graph[3].add(new Edge(3, 1, 0));
       graph[3].add(new Edge(3, 4, 4));

    //    graph[4].add(new Edge(4, 0, 0));
       graph[4].add(new Edge(4, 1, -1));
       
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

   public static void bellman_ford_algo(ArrayList<Edge> graph[],int V,int[] dist){

    for(int k=0;k<V-1;k++){ // Why V-1 ?  Because to check all posible path from all node which are V-1 
 
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if(dist[u]!=Integer.MAX_VALUE &&  dist[u]+ wt < dist[v]){
                    dist[v]= dist[u] + wt; 
                }
            }
        }

    }


    // Detect -ve Wieght Cycle 
    for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[i].size();j++){
            Edge e = graph[i].get(j);
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;
            if(dist[u]!=Integer.MAX_VALUE &&  dist[u]+ wt < dist[v]){
                System.out.println("-----------Negative Wieght Cycle FOUND---------");
            }
        }
    }
    

   }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Bellman ford Algorithm
 
       int[] dist = new int[V];
       for(int i=0;i<V;i++){
        if(i!=0){
            dist[i]=Integer.MAX_VALUE;
        }
       } 

       bellman_ford_algo(graph,V,dist);
       
       for(int i=0;i<dist.length;i++){
        System.out.print(dist[i]+ " ");
       }
       System.out.println();
        
    }

}
