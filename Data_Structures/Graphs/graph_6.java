import java.util.ArrayList;
import java.util.Stack;
public class graph_6 {
    
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

    //    graph[0].add(new Edge(0, 1, 0));
    //    graph[0].add(new Edge(0, 2, 0));
    //    graph[0].add(new Edge(0, 3, 0));
    //    graph[0].add(new Edge(0, 4, 0));


    //    graph[1].add(new Edge(1, 0, 0));
    //    graph[1].add(new Edge(1, 3, 0));


    //    graph[2].add(new Edge(2, 0, 0));
       graph[2].add(new Edge(2, 3, 0));
    //    graph[2].add(new Edge(2, 4, 0));

    //    graph[3].add(new Edge(3, 0, 0));
       graph[3].add(new Edge(3, 1, 0));
    //    graph[3].add(new Edge(3, 2, 0));

       graph[4].add(new Edge(4, 0, 0));
       graph[4].add(new Edge(4, 1, 0));

       graph[5].add(new Edge(5, 0, 0));
       graph[5].add(new Edge(5, 2, 0));
       
       
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

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis ,Stack<Integer> top_sort){
 
        vis[curr] = true;
        // System.out.println(curr + "dfs");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(!vis[neigh]){
              dfs(graph, neigh, vis,top_sort);
            }
        }
      top_sort.push(curr);
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Topological Sorting
 
        boolean[] vis = new boolean[V];
        Stack<Integer> top_sort = new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
            dfs(graph,i,vis,top_sort);
        }
        }

        while(!top_sort.empty()){
         System.out.print(top_sort.pop()+" ");
        }
       System.out.println();
        
    }

}

