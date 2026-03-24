import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        int count = 0;
        int cost = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty() && count < n) {
            Node curr = pq.poll();

            if (visit[curr.u]) {
                continue;
            }

            visit[curr.u] = true;
            count++;
            cost += curr.d;

            for (Node next:nodes[curr.u]) {
                if (visit[next.u]) {
                    continue;
                }

                pq.add(next);
            }
        }

        System.out.println(cost);
    }

    static class Node implements Comparable<Node> {
        int u;
        int d;

        public Node(int u, int d) {
            this.u = u;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
}
