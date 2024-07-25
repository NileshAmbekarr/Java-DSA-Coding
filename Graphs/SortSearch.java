package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SortSearch {
    public static  class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void creteGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }
    public static void indegree(ArrayList<Edge>[] graph, int[] indeg){
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(i);
                indeg[e.dest]++;
            }
        }
    }
    public static void topoSort(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[graph.length];

    }

    public static void main(String[] args) {

    }
}
