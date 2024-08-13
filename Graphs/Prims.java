package Graphs;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));


        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; // will be sorted in ascending order
        }
    }

    // To find the total weight of the minimum spanning tree MST in any graph
    public static void prims(ArrayList<Edge>[] graph){
        // define Visit Array to track vertices
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();  // for storing a pair of vertic and its distance from source
        pq.add(new Pair(0, 0)); // Add source and distance pair (0, 0)
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove(); // remove Pair from pq(which will eventually have the lowest distance value
            if(!vis[curr.v]){   // if it's not visited
                vis[curr.v] = true;  // visit it
                finalCost += curr.cost;  // update finalCost

                for (int i = 0; i < graph[curr.v].size(); i++){  // Add its neighbours to PQ
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalCost);

    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
