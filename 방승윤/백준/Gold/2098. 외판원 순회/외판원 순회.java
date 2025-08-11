import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] W;
    static int[][] dp;

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
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(1, 0));
    }

    public static int tsp(int mask, int curr) {
        if (mask == (1 << N) - 1) {
            return W[curr][0];
        }

        if (dp[curr][mask] != -1) {
            return dp[curr][mask];
        }

        int min = 100_000_000;

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                min = Math.min(min, W[curr][i] + tsp(mask + (1 << i), i));
            }
        }

        return dp[curr][mask] = min;
    }
}