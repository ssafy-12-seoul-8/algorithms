import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] spaceGod = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            spaceGod[i][0] = Integer.parseInt(st.nextToken());
            spaceGod[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = Math.sqrt((double) (spaceGod[i][0] - spaceGod[j][0]) * (spaceGod[i][0] - spaceGod[j][0]) + (double) (spaceGod[i][1] - spaceGod[j][1]) * (spaceGod[i][1] - spaceGod[j][1]));
                pq.add(new Node(i, j, dist));
            }
        }
        
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            if (union(u, v, p)) {
                count++;
            }
        }

        double distSum = 0;
        while (count < n - 1) {
            Node curr = pq.poll();
            if (union(curr.u, curr.v, p)) {
                count++;
                distSum += curr.dist;
            }
        }

        System.out.printf("%.2f", distSum);
    }

    static int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x], p);
    }

    static boolean union(int x, int y, int[] p) {
        int px = find(x, p);
        int py = find(y, p);

        if (px == py) {
            return false;
        }

        p[px] = py;
        return true;
    }

    static class Node implements Comparable<Node> {
        int u;
        int v;
        double dist;

        public Node(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.dist, o.dist);
        }
    }
}
