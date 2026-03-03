import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        br.readLine();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[u].add(new Node(v, c, d));
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(nodes[i]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0, 0));
        int[][] dist = new int[n + 1][m + 1];
        for (int i = 2; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.u == n) {
                break;
            }

            if (dist[curr.u][curr.c] > curr.d) {
                continue;
            }

            for (Node nd:nodes[curr.u]) {
                if (curr.c + nd.c > m) {
                    continue;
                }
                if (dist[nd.u][curr.c + nd.c] > curr.d + nd.d) {
                    for (int i = curr.c + nd.c; i <= m; i++) {
                        if (dist[nd.u][i] < curr.d + nd.d) {
                            break;
                        }
                        dist[nd.u][i] = curr.d + nd.d;
                    }
                    pq.add(new Node(nd.u, curr.c + nd.c, curr.d + nd.d));
                }
            }
        }

        System.out.println(dist[n][m] == Integer.MAX_VALUE ? "Poor KCM" : dist[n][m]);
    }

    private static class Node implements Comparable<Node>{
        int u;
        int c;
        int d;

        public Node(int u, int c, int d) {
            this.u = u;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d) {
                return this.c - o.c;
            }
            return this.d - o.d;
        }
    }
}
