import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static int E;
    static List<Edge>[] conn;

    static class Edge implements Comparable<Edge> {
        int v;
        int d;

        Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }


        @Override
        public int compareTo(Edge edge) {
            return this.d - edge.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        conn = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            conn[a].add(new Edge(b, c));
            conn[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int a = dijkstra(1, v1);
        int b = dijkstra(v1, v2);
        int c = dijkstra(v2, N);
        int d = dijkstra(1, v2);
        int e = dijkstra(v2, v1);
        int f = dijkstra(v1, N);
        if ((a == 10_000_000 || b == 10_000_000 || c == 10_000_000) && (d == 10_000_000 || e == 10_000_000 || f == 10_000_000)) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(a + b + c, d + e + f));
        }
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 10_000_000);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            if (e.d > dist[e.v]) {
                continue;
            }

            for (Edge next : conn[e.v]) {
                int nextD = dist[e.v] + next.d;

                if (nextD < dist[next.v]) {
                    dist[next.v] = nextD;
                    pq.add(new Edge(next.v, nextD));
                }
            }
        }

        return dist[end];
    }
}