import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
//        int INF = 5_000_000; // 최대 10,000*500
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0; // 1에서 시작
        for (int i = 1; i < n; i++) { // n-1번 반복
            for (Edge e : graph) { // 모든 간선을 확인하는데
                if (dist[e.u] == Long.MAX_VALUE) { // i번 안에 시작점에 못오면 pass
                    continue;
                }

                if (dist[e.v] > dist[e.u] + e.w) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (Edge e : graph) {
            if (dist[e.u] == Long.MAX_VALUE) {
                continue;
            }

            if (dist[e.v] > dist[e.u] + e.w) { // n-1번 돌았는데도 갱신이 되면 음수 사이클 있음
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
