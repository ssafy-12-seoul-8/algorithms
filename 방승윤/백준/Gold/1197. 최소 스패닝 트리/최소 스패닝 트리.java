import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Node implements Comparable<Node> {
        int a;
        int b;
        int c;

        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo (Node node) {
            return this.c - node.c;
        }
    }

    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.add(new Node(A, B, C));
        }

        p = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (find(cur.a) == find(cur.b)) {
                continue;
            }

            union(cur.a, cur.b);
            ans += cur.c;
        }

        System.out.println(ans);
    }

    static void union(int x, int y) {
        p[find(y)] = find(x);
    }

    static int find(int x) {
        if (x == p[x]) {
            return x;
        }

        return p[x] = find(p[x]);
    }
}