import java.io.*;
import java.util.*;

public class Main {
    static int n, x, z, p;
    static ArrayList<Node>[] nodes;
    static int[] ps;
    static long[][] dists;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());

            nodes[u].add(new Node(v, w));
            nodes[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        p = Integer.parseInt(br.readLine());
        ps = new int[p];
        dists = new long[p][p + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            ps[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) {
            dijkstra(i);
        }

        dp = new long[p + 1][1 << p];
        long ans = tsp(p, 0);
        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }

    static long tsp(int pIdx, int visit) {
        if (dp[pIdx][visit] != 0) {
            return dp[pIdx][visit];
        }

        if (visit == ((1 << p) - 1)) {
            return dists[pIdx][p + 1];
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < p; i++) {
            if ((visit & (1 << i)) != 0) {
                continue;
            }

            long res = tsp(i, visit | (1 << i));
            if (dists[i][pIdx] == Long.MAX_VALUE || res == Long.MAX_VALUE) {
                continue;
            }

            min = Math.min(min, tsp(i, visit | (1 << i)) + dists[i][pIdx]);
        }

        return dp[pIdx][visit] = min;
    }

    static void dijkstra(int pIdx) {
        long[] dist = new long[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(ps[pIdx], 0));
        dist[ps[pIdx]] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.to]) {
                continue;
            }

            visit[curr.to] = true;
            for (Node next:nodes[curr.to]) {
                if (dist[next.to] > curr.dist + next.dist) {
                    pq.add(new Node(next.to, curr.dist + next.dist));
                    dist[next.to] = curr.dist + next.dist;
                }
            }
        }

        for (int i = 0; i < p; i++) {
            dists[pIdx][i] = dist[ps[i]];
        }
        dists[pIdx][p] = dist[x];
        dists[pIdx][p + 1] = dist[z];
    }

    static class Node implements Comparable<Node> {
        int to;
        long dist;

        public Node(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }
}
