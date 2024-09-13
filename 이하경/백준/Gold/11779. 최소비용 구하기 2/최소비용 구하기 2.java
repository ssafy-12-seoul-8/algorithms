import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라 + parent 배열
public class Main {
    static int n, m, start, end;
    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws Exception {
        input();
        dijkstra();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // Node 1개당 int 2개, 최대 100,000개이므로 800kb
        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, weigh));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void dijkstra() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 많이 들어가봤자 100,000개, 800kb
        int[] parent = new int[n + 1]; // 얘를 방문배열 겸 써야지
        int[] dist = new int[n + 1]; // int배열 2개 8kb
        Arrays.fill(dist, Integer.MAX_VALUE); // 최대 1000*100,000
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.w > dist[curr.v]) {
                continue;
            }

            if (curr.v == end) {
                sb.append(curr.w).append("\n");
                break;
            }

            for (Node next : nodes[curr.v]) {
                if (dist[next.v] > curr.w + next.w) {
                    dist[next.v] = curr.w + next.w;
                    parent[next.v] = curr.v;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while (end != 0) {
            stack.push(end);
            end = parent[end];
        }

        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int v, w;

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
