package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {
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

    public static void createGraph(int[][] flights,  ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost , int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }
    // Cheapest Flight function
    public static void cheapestFlights(int[][] flights, int src, int dest, int k, int n ){
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if (curr.stops > k ){
                break;
            }

            for (int i = 0; i < graph[curr.vertex]; i++){
                
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int k = 1;
    }
}
