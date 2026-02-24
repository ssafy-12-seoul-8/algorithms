import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            nodes[u].add(new Node(v, d, 0));
            nodes[v].add(new Node(u, d, 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[][] dist = new long[n + 1][k + 1];
        for (long[] d:dist) {
            Arrays.fill(d, Long.MAX_VALUE);
        }
        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.to == n) {
                System.out.println(curr.dist);
                return;
            }

            if (dist[curr.to][curr.wrap] < curr.dist) {
                continue;
            }

            for (Node nd:nodes[curr.to]) {
                if (curr.dist + nd.dist < dist[nd.to][curr.wrap]) {
                    dist[nd.to][curr.wrap] = curr.dist + nd.dist;
                    pq.add(new Node(nd.to, curr.dist + nd.dist, curr.wrap));
                }
            }

            if (curr.wrap < k) {
                for (Node nd:nodes[curr.to]) {
                    if (curr.dist < dist[nd.to][curr.wrap + 1]) {
                        dist[nd.to][curr.wrap + 1] = curr.dist;
                        pq.add(new Node(nd.to, curr.dist, curr.wrap + 1));
                    }
                }
            }


        }
    }

    private static class Node implements Comparable<Node> {
        int to;
        long dist;
        int wrap;

        public Node(int to, long dist, int wrap) {
            this.to = to;
            this.dist = dist;
            this.wrap = wrap;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }
}
