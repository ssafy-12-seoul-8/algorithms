import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 교차로
            int m = Integer.parseInt(st.nextToken()); // 도로
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken()); // 도로양쪽중1
            int h = Integer.parseInt(st.nextToken()); // 도로양쪽중2

            ArrayList<Node>[] nodes = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if ((a == g && b == h) || (a == h && b == g)) {
                    nodes[a].add(new Node(b, d, true));
                    nodes[b].add(new Node(a, d, true));
                    continue;
                }
                nodes[a].add(new Node(b, d));
                nodes[b].add(new Node(a, d));
            }

            Set<Integer> target = new HashSet<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                target.add(x);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            PriorityQueue<Integer> ans = new PriorityQueue<>();
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Node(s, 0));

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                if (dist[curr.u] != Integer.MAX_VALUE) {
                    continue;
                }

                if (curr.passed && target.contains(curr.u)) {
                    ans.add(curr.u);
                }

                dist[curr.u] = curr.d;

                for (Node nd : nodes[curr.u]) {
                    if (dist[nd.u] == Integer.MAX_VALUE) {
                        pq.add(new Node(nd.u, curr.d + nd.d, curr.passed || nd.passed));
                    }
                }
            }

            while (!ans.isEmpty()) {
                sb.append(ans.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        int u;
        int d;
        boolean passed;

        public Node(int u, int d) {
            this.u = u;
            this.d = d;
            this.passed = false;
        }

        public Node(int u, int d, boolean passed) {
            this.u = u;
            this.d = d;
            this.passed = passed;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d) {
                if (this.passed == o.passed) {
                    return 0;
                }
                if (this.passed) {
                    return -1;
                }
                return 1;
            }
            return this.d - o.d;
        }
    }
}
