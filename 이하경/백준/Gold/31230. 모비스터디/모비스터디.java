import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            nodes[u].add(new Node(v, d));
            nodes[v].add(new Node(u, d));
        }

        long[] distA = dijkstra(a);
        long[] distB = dijkstra(b);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distA[i] + distB[i] == distA[b]) {
                ans.add(i);
            }
        }

        sb.append(ans.size()).append("\n");
        for (int an:ans) {
            sb.append(an).append(" ");
        }

        System.out.println(sb);
    }

    public static long[] dijkstra(int start) {
        long[] dist = new long[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;

            for(Node next:nodes[curr.u]) {
                if (visit[next.u]) {
                    continue;
                }

                if (dist[next.u] > curr.d + next.d) {
                    dist[next.u] = curr.d + next.d;
                    pq.add(new Node(next.u, curr.d + next.d));
                }
            }
        }

        return dist;
    }

    private static class Node implements Comparable<Node> {
        int u;
        long d;

        public Node(int u, long d) {
            this.u = u;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }
}
