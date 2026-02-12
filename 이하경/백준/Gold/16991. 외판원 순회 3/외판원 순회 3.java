import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static double[][] dist;
    static double[][] dp;
    static double INF = 50000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dist = new double[n][n];
        dp = new double[n][1 << n];

        int[][] point = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = INF;
            for (int j = i + 1; j < n; j++) {
                double d = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
                dist[i][j] = d;
                dist[j][i] = d;
            }
        }

        System.out.println(tsp(0, 1));
    }

    static double tsp(int now, int visit) {
        if (dp[now][visit] != 0) {
            return dp[now][visit];
        }

        if (visit == (1 << n) - 1) {
            return dist[now][0];
        }

        dp[now][visit] = INF;
        for (int i = 1; i < n; i++) {
            if ((visit & (1 << i)) > 0) {
                continue;
            }
            dp[now][visit] = Math.min(dp[now][visit], dist[now][i] + tsp(i, visit | (1 << i)));
        }

        return dp[now][visit];
    }
}
