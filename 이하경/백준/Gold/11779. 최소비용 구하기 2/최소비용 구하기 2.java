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

        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(from, to, weigh));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void dijkstra() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] parent = new int[n + 1]; // 얘를 방문배열 겸 써야지
        pq.addAll(nodes[start]);
        parent[start] = start;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (parent[curr.v] != 0) {
                continue;
            }

            parent[curr.v] = curr.u;

            if (curr.v == end) {
                sb.append(curr.w).append("\n");
                break;
            }

            for (Node next : nodes[curr.v]) {
                pq.add(new Node(next.u, next.v, curr.w + next.w));
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while (end != start) {
            stack.push(end);
            end = parent[end];
        }
        stack.push(start);

        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    static class Node implements Comparable<Node> {
        int u, v, w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
