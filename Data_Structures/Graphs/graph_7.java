// Dijkstra’s shortest path algorithm
import java.util.ArrayList;
import java.util.PriorityQueue;

class graph_7 {

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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        // graph[0].add(new Edge(0, 3, 0));
        // graph[0].add(new Edge(0, 4, 0));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        // graph[2].add(new Edge(2, 0, 0));
        // graph[2].add(new Edge(2, 3 ,0));
        graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 0, 0));
        // graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

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

    public static void bfs(ArrayList<Edge> graph[], boolean[] vis, PriorityQueue<Pair> pq, int[] dist) {

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int neigh = e.dest;
                    int weight = e.wt;
                    if (dist[curr.node] + weight < dist[neigh]) {
                        dist[neigh] = dist[curr.node] + weight;
                        pq.add(new Pair(neigh, dist[neigh]));
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // // Dijkstra’s shortest path algorithm

        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        q.add(new Pair(0, 0));

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != 0) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        bfs(graph, vis, q, dist);

        for (int i = 0; i < V; i++) {
            System.out.print(dist[i]+ " ");
        }

        System.out.println();


    }
}