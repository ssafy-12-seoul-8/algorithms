import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[a].add(new Node(b, 1 - c));
            nodes[b].add(new Node(a, 1 - c));
        }

        boolean[] visit = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        int minDist = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.to]) {
                continue;
            }

            visit[curr.to] = true;
            minDist += curr.dist;

            for (Node next : nodes[curr.to]) {
                if (!visit[next.to]) {
                    pq.add(next);
                }
            }
        }

        pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Node(0, 0));
        int maxDist = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (!visit[curr.to]) {
                continue;
            }

            visit[curr.to] = false;
            maxDist += curr.dist;

            for (Node next : nodes[curr.to]) {
                if (visit[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(maxDist * maxDist - minDist * minDist);
    }

    private static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
