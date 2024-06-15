package Heaps;

import java.util.PriorityQueue;

public class NearbyCars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point point){
            return this.distSq - point.distSq;
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length - 1 ; i++){
            int distSq = pts[i][0] * pts[i][0] + pts[1][i] * pts[1][i];
            pq.add(new Point(pts[i][0], pts[1][i], distSq, i));
        }

        // printing nearest k cars / points
        for(int i = 0; i < k ; i++){
            System.out.println("C" + pq.remove().idx);
        }
    }
}
