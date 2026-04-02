import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            nodes[u].add(new Node(u, v, d));
            nodes[v].add(new Node(v, u, d));
        }

        long[] dist = new long[n + 1];
        boolean[] visit = new boolean[n + 1];
        ArrayList<Integer>[] prev = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[a] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, a, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                if (dist[curr.v] == curr.d) {
                    prev[curr.v].add(curr.u);
                }
                continue;
            }

            visit[curr.v] = true;
            prev[curr.v].add(curr.u);

            for (Node next:nodes[curr.v]) {
                if (visit[next.v]) {
                    if (dist[next.v] == curr.d + next.d) {
                        prev[next.v].add(curr.v);
                    }
                    continue;
                }

                if (dist[next.v] >= curr.d + next.d) {
                    dist[next.v] = curr.d + next.d;
                    pq.add(new Node(curr.v, next.v, curr.d + next.d));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        ans.add(b);
        q.add(b);
        visit[b] = false;
        visit[0] = false;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int p:prev[curr]) {
                if (visit[p]) {
                    visit[p] = false;
                    ans.add(p);
                    q.add(p);
                }
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (int an:ans) {
            sb.append(an).append(" ");
        }

        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        int u;
        int v;
        long d;

        public Node(int u, int v, long d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }
}
