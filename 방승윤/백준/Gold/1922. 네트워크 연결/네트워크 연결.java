import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a, b, c));
        }

        Collections.sort(edgeList);

        int cost = 0;

        for (Edge e : edgeList) {
            if (find(e.a) != find(e.b)) {
                union(e.a, e.b);
                cost += e.c;
            }
        }

        System.out.println(cost);
    }

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

}