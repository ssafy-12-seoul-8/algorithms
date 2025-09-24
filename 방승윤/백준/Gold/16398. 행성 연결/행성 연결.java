import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int c;

        Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.c - edge.c;
        }
    }

    public static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        p = new int[N];

        for (int i = 1; i < N; i++) {
            p[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int c = Integer.parseInt(st.nextToken());

                if (i < j) {
                    pq.add(new Edge(i, j, c));
                }
            }
        }

        long cost = 0;

        while (N > 1) {
            Edge curr = pq.poll();
            int u = curr.u;
            int v = curr.v;
            int c = curr.c;
            int x = find(u);
            int y = find(v);

            if (x != y) {
                N--;
                union(x, y);
                cost += c;
            }
        }

        System.out.println(cost);
    }

    public static int find(int x) {
        if (x == p[x]) {
            return p[x];
        }

        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
        p[y] = x;
    }
}