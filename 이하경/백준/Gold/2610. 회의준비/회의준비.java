import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int INF = 10000;

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    dist[j][i] = dist[i][j];
                }
            }
        }

        ArrayList<Integer> boss = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                int min = INF;
                int minIdx = i;
                for (int j = i; j <= n; j++) {
                    if (dist[i][j] == INF) {
                        continue;
                    }
                    visit[j] = true;
                    int tmp = 0;
                    for (int k = 1; k <= n; k++) {
                        if (dist[j][k] < INF) {
                            tmp = Math.max(tmp, dist[j][k]);
                        }
                    }
                    if (tmp < min) {
                        min = tmp;
                        minIdx = j;
                    }
                }
                boss.add(minIdx);
            }
        }

        Collections.sort(boss);
        sb.append(boss.size()).append("\n");
        for (int b:boss) {
            sb.append(b).append("\n");
        }

        System.out.println(sb);
    }
}
