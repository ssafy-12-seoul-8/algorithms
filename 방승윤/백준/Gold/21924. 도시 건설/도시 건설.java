import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] conn = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        long total = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            conn[a].add(new Edge(b, c));
            conn[b].add(new Edge(a, c));
            total += c;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.v]) {
                continue;
            }

            visited[curr.v] = true;
            total -= curr.w;

            for (Edge next : conn[curr.v]) {
                if (!visited[next.v]) {
                    pq.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total);
    }
}