import java.util.ArrayList;
import java.util.Stack;
public class graph_10 {
    
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
       graph[0].add(new Edge(0, 2, 0));
       graph[0].add(new Edge(0, 3, 0));
    //    graph[0].add(new Edge(0, 4, 0));


       graph[1].add(new Edge(1, 0, 0));
    //    graph[1].add(new Edge(1, 3, 0));


    //    graph[2].add(new Edge(2, 0, 0));
       graph[2].add(new Edge(2, 1, 0));
    //    graph[2].add(new Edge(2, 4, 0));

    //    graph[3].add(new Edge(3, 0, 0));
    //    graph[3].add(new Edge(3, 1, 0));
       graph[3].add(new Edge(3, 4, 0));

    //    graph[4].add(new Edge(4, 0, 0));
    //    graph[4].add(new Edge(4, 1, 0));

    //    graph[5].add(new Edge(5, 0, 0));
    //    graph[5].add(new Edge(5, 2, 0));
       
       
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

    public static void topological_sort(ArrayList<Edge> graph[],int curr,boolean[] vis ,Stack<Integer> top_sort){
 
        vis[curr] = true;
        // System.out.println(curr + "dfs");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(!vis[neigh]){
                topological_sort(graph, neigh, vis,top_sort);
            }
        }
      top_sort.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis){
 
        vis[curr] = true;
        System.out.println(curr + "dfs");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(!vis[neigh]){
                dfs(graph, neigh, vis);
            }
        }
    }

    public static ArrayList<Edge>[] transpose_graph(ArrayList<Edge> graph[],int V){

        ArrayList<Edge> transpose[] =new ArrayList[V];

        for(int i=0;i<V;i++){
            transpose[i]=new ArrayList<Edge>();
       }
       for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[i].size();j++){
            Edge e = graph[i].get(j);
            int dest = e.dest;
            int src  = e.src;
            transpose[dest].add(new Edge(dest,src,0));
        }
    }
        return transpose;
    }

    public static void kosajraju_algorithm(ArrayList<Edge> graph[],int V){
 
         // Topological Sorting
         boolean[] vis = new boolean[V];
         Stack<Integer> top_sort = new Stack<>();
 
         for(int i=0;i<V;i++){
             if(!vis[i]){
                topological_sort(graph,i,vis,top_sort);
         }
         }


         System.out.println("Topological Sorting");
         while(!top_sort.empty()){
          System.out.print(top_sort.pop()+" ");
         }
         System.out.println();

         ArrayList<Edge> tranpose[] = transpose_graph(graph,V);

         for(int i=0;i<tranpose.length;i++){
            vis[i]=false;
            for(int j=0;j<tranpose[i].size();j++){
                Edge e = tranpose[i].get(j);
                int dest = e.dest;
                int src  = e.src;
                // System.out.println("Edge------------"+src+"---------->"+dest  );
            }
        }


        for(int i=0;i<V;i++){
            if(!vis[i]){
               dfs(tranpose, i, vis);
               System.out.println("---------");
        }
        }



    }



    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Kosajraju Alogorithm 
        kosajraju_algorithm(graph, V);
        
    }

}

