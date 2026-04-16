import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        int INF = 100_000_000;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        int[] macDist = new int[v + 1];
        Arrays.fill(macDist, INF);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mac = Integer.parseInt(st.nextToken());
            pq.add(new Node(mac, 0));
            macDist[mac] = 0;
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;
            for (Node next:nodes[curr.u]) {
                int nd = curr.w + next.w;
                if (macDist[next.u] > nd) {
                    macDist[next.u] = nd;
                    pq.add(new Node(next.u, nd));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        visit = new boolean[v + 1];
        int[] sbDist = new int[v + 1];
        Arrays.fill(sbDist, INF);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int sb = Integer.parseInt(st.nextToken());
            pq.add(new Node(sb, 0));
            sbDist[sb] = 0;
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;
            for (Node next:nodes[curr.u]) {
                int nd = curr.w + next.w;
                if (sbDist[next.u] > nd) {
                    sbDist[next.u] = nd;
                    pq.add(new Node(next.u, nd));
                }
            }
        }

        int min = x + y + 1;
        for (int i = 1; i <= v; i++) {
            if (macDist[i] != 0 && macDist[i] <= x && sbDist[i] != 0 && sbDist[i] <= y) {
                min = Math.min(min, macDist[i] + sbDist[i]);
            }
        }

        System.out.println(min == x + y + 1 ? -1 : min);
    }

    static class Node implements Comparable<Node> {
        int u;
        int w;

        public Node(int u, int w) {
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
