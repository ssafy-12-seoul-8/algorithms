import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k, w;
    static int[] delay, inDegree;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            input();
            solve();
        }
        System.out.println(sb);
    }

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        delay = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            delay[i] = Integer.parseInt(st.nextToken());
        }

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        inDegree = new int[n + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
            inDegree[y]++;
        }

        w = Integer.parseInt(br.readLine());
    }

    static void solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                if (i == w) {
                    sb.append(delay[i]).append("\n");
                    return;
                }
                pq.add(new Node(i, delay[i]));
            }
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll(); // 번호와, 거기까지 짓는데 걸린 시간 나옴

            for (int next : edges[curr.v]) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    if (next == w) {
                        sb.append(curr.wait + delay[next]).append("\n");
                        return;
                    }
                    pq.add(new Node(next, curr.wait + delay[next]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, wait;

        public Node(int v, int wait) {
            this.v = v;
            this.wait = wait;
        }

        @Override
        public int compareTo(Node o) {
            return this.wait - o.wait;
        }
    }
}
