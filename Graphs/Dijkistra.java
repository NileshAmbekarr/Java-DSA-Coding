package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkistra {
    public static class Edge {
        int src;
        int dest;
        int w;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.w = w;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static class Pair implements Comparable<Pair> {
        int n; // Node
        int dist; // Dist from source to Node

        public Pair(int n, int dist){
            this.n = n;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        for (int i= 0; i < graph.length; i++){
           if (i != src){
               dist[i] = Integer.MAX_VALUE;
           }
        }

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.n]){
                vis[curr.n] = true;

                //neighbours add to the queue
                for (int i = 0; i < graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.w; //weight

                    // relaxation step
                    if (dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;

                        // push new pair to PQueue
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all the src to vertices shortest distances
        for (int j : dist) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        int src = 0;
        createGraph(graph);
        dijkstra(graph, src);
    }
}
