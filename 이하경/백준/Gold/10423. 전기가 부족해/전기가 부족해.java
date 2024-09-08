import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 크루스칼이 아니라 프림을 선택한 이유
// 발전소 노드들에서 시작하면 방문 = 발전소 연결이 보장됨
// 크루스칼을 사용하면 발전소와 연결되었을 때 표시해줘야함

public class Main {
    static int n, m, k;
    static int[] power;
    static ArrayList<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(prim());
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        power = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }
    }

    static int prim () {
        boolean[] connected = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            connected[power[i]] = true;
            pq.addAll(edges[power[i]]); // 발전소와 연결된 모든 노드를 넣는다
        }

        int pick = k;
        int cost = 0;
        while (pick < n) {
            Edge curr = pq.poll();

            if (connected[curr.v]) {
                continue;
            }
            connected[curr.v] = true;
            pick++;
            cost += curr.w;

            for (Edge e : edges[curr.v]) {
                if (!connected[e.v]) {
                    pq.add(e);
                }
            }
        }

        return cost;
    }

    static class Edge implements Comparable<Edge> {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
