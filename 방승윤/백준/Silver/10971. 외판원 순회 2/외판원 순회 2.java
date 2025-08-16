import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int full;
    static int INF = 100_000_000;
    static int[][] dp;
    static int[][] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        full = (1 << N) - 1;
        dp = new int[full][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());

                if (W[i][j] == 0) {
                    W[i][j] = INF;
                }
            }
        }

        for (int[] dp : dp) {
            Arrays.fill(dp, -1);
        }

        System.out.println(tsp(1, 0));
    }

    public static int tsp(int mask, int curr) {
        if (mask == full) {
            return W[curr][0];
        }

        if (dp[mask][curr] != -1) {
            return dp[mask][curr];
        }

        dp[mask][curr] = INF;

        for (int i = 0; i < N; i++) {
            if (W[curr][i] == INF || (mask & (1 << i)) != 0) {
                continue;
            }

            dp[mask][curr] = Math.min(dp[mask][curr], W[curr][i] + tsp(mask | (1 << i), i));
        }

        return dp[mask][curr];
    }
}