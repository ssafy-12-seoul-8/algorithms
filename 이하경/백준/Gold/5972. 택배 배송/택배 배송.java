import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(dijkstra());
    }

    static void input() throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
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
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        boolean[] visit = new boolean[n + 1];
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;

            if (curr.v == n) {
                return curr.w;
            }

            for (Node next : nodes[curr.v]) {
                if (!visit[next.v]) {
                    pq.add(new Node(next.v, curr.w + next.w));
                }
            }
        }
        return -1;
    }

    static class Node {
        int v, w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
