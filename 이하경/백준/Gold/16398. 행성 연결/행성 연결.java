import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] flows = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                flows[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visit = new boolean[n];
        long sum = 0;
        int count = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        while (!pq.isEmpty() && count < n) {
            Node curr = pq.poll();
            if (visit[curr.to]) {
                continue;
            }
            visit[curr.to] = true;
            sum += curr.dist;
            count++;

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    pq.add(new Node(i, flows[curr.to][i]));
                }
            }
        }

        System.out.println(sum);
    }

    private static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.dist = dist;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
