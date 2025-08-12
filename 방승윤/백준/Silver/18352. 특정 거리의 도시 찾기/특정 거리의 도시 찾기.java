import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int v;
        int d;

        Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edge e){
            return this.d - e.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Edge>[] conn = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            conn[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), 1));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        pq.add(new Edge(X, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            for (Edge edge : conn[e.v]) {
                if (dist[edge.v] > edge.d + e.d) {
                    dist[edge.v] = edge.d + e.d;
                    pq.add(new Edge(edge.v, edge.d + e.d));
                }
            }
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                cnt++;
                System.out.println(i);
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }
    }
}