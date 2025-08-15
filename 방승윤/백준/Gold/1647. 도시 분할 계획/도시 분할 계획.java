import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        ArrayList<Edge> conn = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            conn.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(conn);
        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        int cost = 0;

        for (Edge edge : conn) {
            if (N == 2) {
                break;
            }

            int x = find(edge.u);
            int y = find(edge.v);

            if (x != y) {
                cost += edge.w;
                union(x, y);
                N--;
            }
        }

        System.out.println(cost);
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