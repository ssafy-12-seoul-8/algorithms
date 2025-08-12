import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int[] p;

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
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
        List<Edge> conn = new ArrayList<>();
        long total = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            conn.add(new Edge(a, b, c));
            total += c;
        }

        Collections.sort(conn);
        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (Edge e : conn) {
            if (find(e.u) != find(e.v)) {
                union(find(e.u), find(e.v));
                total -= e.w;
                N--;
            }
        }

        System.out.println(N == 1 ? total : -1);
    }

    static void union(int x, int y) {
        p[y] = x;
    }

    static int find(int x) {
        if (x == p[x]) {
            return p[x];
        }

        return p[x] = find(p[x]);
    }
}