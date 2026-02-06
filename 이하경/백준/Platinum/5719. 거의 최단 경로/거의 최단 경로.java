import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 거리는 최대 np = 500_000
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n != 0 && m != 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] nodes = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                nodes[u].add(new Node(v, p));
            }

            int MAX = 500_000;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(s, 0));
            int[] dist = new int[n];
            Arrays.fill(dist, MAX);
            dist[s] = 0;
            ArrayList<Integer>[] prev = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                prev[i] = new ArrayList<>();
            }

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                for (Node nd : nodes[curr.v]) {
                    if (curr.w + nd.w < dist[nd.v]) {
                        dist[nd.v] = curr.w + nd.w;
                        pq.add(new Node(nd.v, curr.w + nd.w));
                        prev[nd.v].clear();
                        prev[nd.v].add(curr.v);
                        continue;
                    }
                    if (curr.w + nd.w == dist[nd.v]) {
                        prev[nd.v].add(curr.v);
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();
            for (int prv:prev[d]) {
                q.add(new int[]{ prv, d });
            }

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (Node nd:nodes[curr[0]]) {
                    if (nd.v == curr[1]) {
                        nodes[curr[0]].remove(nd);
                        for (int prv:prev[curr[0]]) {
                            q.add(new int[]{ prv, curr[0] });
                        }
                        break;
                    }
                }
            }

            pq.clear();
            int[] almost = new int[n];
            Arrays.fill(almost, MAX);
            pq.add(new Node(s, 0));

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                if (almost[curr.v] != MAX) {
                    continue;
                }

                almost[curr.v] = curr.w;
                for (Node nd : nodes[curr.v]) {
                    if (almost[nd.v] == MAX) {
                        pq.add(new Node(nd.v, curr.w + nd.w));
                    }
                }
            }

            sb.append(almost[d] == MAX ? -1 : almost[d]).append("\n");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }

    private static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
