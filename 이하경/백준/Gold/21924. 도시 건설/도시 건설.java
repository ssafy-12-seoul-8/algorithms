import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long total = 0;
        int connected = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            total += c;
            pq.add(new Node(a, b, c));
        }

        int[] p = new int[n + 1];
        long cost = 0;

        for (int i = 0; i < n + 1; i++) {
            p[i] = i;
        }

        while (connected < n && !pq.isEmpty()) {
            Node curr = pq.poll();

            int px = find(curr.a, p);
            int py = find(curr.b, p);

            if (px != py) {
                connected += 1;
                cost += curr.cost;
                union(px, py, p);
            }

        }

        if (connected < n) {
            System.out.println(-1);
            return;
        }

        System.out.println(total - cost);
    }

    private static void union(int a, int b, int[] p) {
        p[b] = a;
    }

    private static int find(int a, int[] p) {
        if (p[a] == a) {
            return a;
        }

        return p[a] = find(p[a], p);
    }

    private static class Node implements Comparable<Node> {
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    ", cost=" + cost +
                    '}';
        }
    }
}
