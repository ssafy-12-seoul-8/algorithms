import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 워셜, 갱신시 표시
// 만약 거리가 같다면 어떤걸 출력?
// 두 집하장 사이의 경로가 여러개일 수 있을까?
// 경로가 없는 경우도 있을까?

public class Main {
    static int INF = 200_000; // 경로 1000*집하장 200개
    static int n, m;
    static int[][] dist;
    static int[][] next;

    public static void main(String[] args) throws Exception {
        input();
        floydWarshall();
        print();
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[u][v], w);
        }
    }

    public static void floydWarshall() {
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) { // i->j로 가려면
                if (i != j && dist[i][j] != INF) { // 경로가 있으면
                    next[i][j] = j;
                }
            }
        }

        for (int k = 1; k <= n; k++) { // 경유
            for (int i = 1; i <= n; i++) { // 출발
                for (int j = 1; j <= n; j++) { // 도착
                    if (i != j && dist[i][j] > dist[i][k] + dist[k][j]) {
                        next[i][j] = next[i][k]; // 거리가 갱신되면 k쪽 길 이용
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(next[i][j] == 0 ? "-" : next[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
