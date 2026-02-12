import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] dist;
    static int[][] dp;
    static int INF = 16_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][(1 << n) - 1] = dist[i][0];
        }

        System.out.println(tsp(0, 1));
    }

    static int tsp(int now, int visit) {
        if (dp[now][visit] > 0) {
            return dp[now][visit];
        }

        dp[now][visit] = INF;
        for (int i = 1; i < n; i++) {
            if (dist[now][i] == 0 || (visit & (1 << i)) > 0) {
                continue;
            }
            dp[now][visit] = Math.min(dp[now][visit], dist[now][i] + tsp(i, visit | (1 << i)));
        }

        return dp[now][visit];
    }
}
