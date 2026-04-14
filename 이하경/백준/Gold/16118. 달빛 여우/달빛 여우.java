import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, d, 1));
            nodes[b].add(new Node(a, d, 1));
        }

        boolean[] visit = new boolean[n + 1];
        double[] dist = new double[n + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 1));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;
            for (Node next : nodes[curr.u]) {
                double nd = curr.d + next.d;
                if (dist[next.u] > nd) {
                    dist[next.u] = nd;
                    pq.add(new Node(next.u, nd, 1));
                }
            }
        }

        boolean[][] visit2 = new boolean[2][n + 1];
        double[][] dist2 = new double[2][n + 1];
        Arrays.fill(dist2[0], Double.MAX_VALUE);
        Arrays.fill(dist2[1], Double.MAX_VALUE);
        pq.add(new Node(1, 0, 0.5));
        dist2[0][1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int idx = curr.speed == 0.5 ? 0 : 1;

            if (visit2[idx][curr.u]) {
                continue;
            }

            visit2[idx][curr.u] = true;

            for (Node next : nodes[curr.u]) {
                double nd = curr.d + next.d * curr.speed;
                if (dist2[1 - idx][next.u]> nd) {
                    dist2[1 - idx][next.u] = nd;
                    pq.add(new Node(next.u, nd, 1 / curr.speed));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist2[0][i] > dist[i] && dist2[1][i] > dist[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    static class Node implements Comparable<Node> {
        int u;
        double d;
        double speed;

        public Node(int u, double d, double speed) {
            this.u = u;
            this.d = d;
            this.speed = speed;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d) {
                return Double.compare(this.speed, o.speed);
            }
            return Double.compare(this.d, o.d);
        }
    }
}
