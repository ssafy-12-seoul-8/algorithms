import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], n);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        floydWarshall();
        System.out.println(findMinKevinBacon());
    }

    static void floydWarshall() {
        for (int i = 1; i <= n; i++) { // 경유
            for (int j = 1; j <= n - 1; j++) { // 출발
                for (int k = j + 1; k <= n; k++) { // 도착
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    dist[k][j] = dist[j][k];
                }
            }
        }
    }

    static int findMinKevinBacon() {
        int min = Integer.MAX_VALUE; // 최대 100 * 100
        int mindIdx = -1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += dist[i][j];
            }
            if (sum < min) {
                min = sum;
                mindIdx = i;
            }
        }

        return mindIdx;
    }
}
