import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sight[i] = Integer.parseInt(st.nextToken());
        }
        sight[n - 1] = 0;

        ArrayList<Node>[] nodes = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (sight[a] == 0 && sight[b] == 0){
                nodes[a].add(new Node(b, t));
                nodes[b].add(new Node(a, t));
            }
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        boolean[] visit = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;

            for (Node next:nodes[curr.u]) {
                if (dist[next.u] > curr.d + next.d) {
                    dist[next.u] = curr.d + next.d;
                    pq.add(new Node(next.u, curr.d + next.d));
                }
            }
        }

        System.out.println(dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1]);
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
