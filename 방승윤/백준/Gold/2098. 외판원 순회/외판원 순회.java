import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] W;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());

                if (W[i][j] == 0) {
                    W[i][j] = 100_000_000;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                dp[i][j] = 100_000_000;
            }
        }

        dp[0][1] = 0;

        tsp(1, 0);

        System.out.println(min);
    }

    public static void tsp(int mask, int curr) {
        if (mask == (1 << N) - 1) {
            if (W[curr][0] != 0) {
                min = Math.min(min, dp[curr][mask] + W[curr][0]);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                if (dp[i][mask + (1 << i)] <= dp[curr][mask] + W[curr][i]) {
                    continue;
                }

                dp[i][mask + (1 << i)] = dp[curr][mask] + W[curr][i];
                tsp(mask + (1 << i), i);
            }
        }
    }
}