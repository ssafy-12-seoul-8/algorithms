import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static int N;
    public static int full;
    public static int INF = 1000000;
    public static double[][] W;
    public static double[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        full = (1 << N) - 1;
        int[][] city = new int[N][2];
        W = new double[N][N];
        dp = new double[1 << N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            city[i][0] = Integer.parseInt(st.nextToken());
            city[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int dx = city[i][0] - city[j][0];
                int dy = city[i][1] - city[j][1];
                double distance = Math.sqrt(dx * dx + dy * dy);
                W[i][j] = distance;
                W[j][i] = distance;
            }
        }

        for (double[] dp : dp) {
            Arrays.fill(dp, -1);
        }

        System.out.println(tsp(1, 0));
    }

    public static double tsp(int mask, int u) {
        if (mask == full) {
            return W[u][0];
        }

        if (dp[mask][u] != -1) {
            return dp[mask][u];
        }

        dp[mask][u] = INF;

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }

            dp[mask][u] = Math.min(dp[mask][u], W[i][u] + tsp(mask | (1 << i), i));
        }
        return dp[mask][u];
    }
}