import java.util.ArrayList;
import java.util.PriorityQueue;

class Algorithm_3 {

    static class Edge {
        int dest;
        int src;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p) {
            return this.dist - p.dist; // ascending
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        // graph[0].add(new Edge(0, 4, 0));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3 ,50));
        // graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));

        // graph[5].add(new Edge(4, 3, 2));
        // graph[5].add(new Edge(4, 5, 5));

    }

    public static void printGraph(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int dest = e.dest;
                int src = e.src;
                System.out.println("Edge------------" + src + "---------->" + dest);
            }
        }
    }

    public static int prims_algorithm(ArrayList<Edge> graph[],int V) {

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 0));
        boolean[] vis = new boolean[V];

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                cost+=curr.dist;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int neigh = e.dest;
                    int weight = e.wt;
                    if(!vis[e.dest]){
                    pq.add(new Pair(neigh, weight));
                    }
                }
            }
        }
        return cost;

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // Prim's algorithm (Minimum Spaning Tree Cost)
       int mst_cost = prims_algorithm(graph,V);

        System.out.println("mst_cost ->"+mst_cost);


    }
}