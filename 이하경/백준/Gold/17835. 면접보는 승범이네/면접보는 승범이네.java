import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 면접장에서 시작해서 거리가 가장 먼 도시 구하기
public class Main {
    static int n, m, k, cnt;
    static ArrayList<Node>[] nodes;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        input();
        dijkstra();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[v].add(new Node(u, c)); // 도로를 반대로 저장
        }

        visit = new boolean[n + 1];
        pq = new PriorityQueue<>();

        cnt = 0;
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int city = Integer.parseInt(st.nextToken());
            cnt++;
            visit[city] = true;
            pq.addAll(nodes[city]);
        }
    }

    static void dijkstra() {
        if (n == k) {
            System.out.println(1);
            System.out.println(0);
            return;
        }

        while (cnt < n - 1) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;
            cnt++;

            for (Node next : nodes[curr.v]) {
                if (!visit[next.v]) {
                    pq.add(new Node(next.v, curr.w + next.w));
                }
            }
        }

        while (true) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }

            System.out.println(curr.v);
            System.out.println(curr.w);
            return;
        }
    }

    // 최대거리는 100,000*100,000
    static class Node implements Comparable<Node> {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if (this.w == o.w) {
                return o.v - this.v; // 번호 큰게 먼저 뽑히게
            }
            return Long.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}

