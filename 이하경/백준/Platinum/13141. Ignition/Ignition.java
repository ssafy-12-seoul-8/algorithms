import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int INF = 200000;

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        ArrayList<Edge>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dist[s][e] = Math.min(dist[s][e], l);
            dist[e][s] = Math.min(dist[e][s], l);
            edges[s].add(new Edge(e, l));
            edges[e].add(new Edge(s, l));
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        dist[j][i] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        double min = INF;
        for (int i = 1; i <= n; i++) { // 시작점 찾기
            double max = 0;
            for (int j = 1; j <= n; j++) { // 모든 노드 탐색
                for (Edge e:edges[j]) {
                    max = Math.max(max, (double) (dist[i][j] + dist[i][e.u] + e.l) / 2);
                }
            }
            min = Math.min(min, max);
        }
        System.out.println(min);
    }

    private static class Edge {
        int u;
        int l;

        public Edge(int u, int l) {
            this.u = u;
            this.l = l;
        }
    }
}
