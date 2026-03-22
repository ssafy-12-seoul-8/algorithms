import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ArrayList<Node>[] nodes = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                nodes[b].add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(c, 0));
            int count = 0;
            int maxTime = 0;
            boolean[] visit = new boolean[n + 1];

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                if (visit[curr.to]) {
                    continue;
                }

                visit[curr.to] = true;
                count += 1;
                maxTime = Math.max(maxTime, curr.dist);

                for (Node next: nodes[curr.to]) {
                    if (visit[next.to]) {
                        continue;
                    }

                    pq.add(new Node(next.to, curr.dist + next.dist));
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");
        }
        System.out.println(sb);
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
